package calc.menu.edit;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import calc.textui.edit.InvalidCellRange;
import calc.textui.edit.MenuEntry;
import calc.textui.edit.Message;
import calc.core.*;

public class Cut extends Command<AppCalc> {

	private FolhaCalculo _folhaCalculo;

	/**
	 * Constructor.
	 * 
	 * @param app
	 * 
	 */
	public Cut(AppCalc app) {
		super(MenuEntry.CUT, app);
	}

	@Override
	public final void execute() throws InvalidCellRange {

		_folhaCalculo = entity().getFolhaCalculo();
		entity().getCutBuffer().clear(); // Cleans the cutBuffer before rewrite it.
		ParseAndGenerator pag = new ParseAndGenerator(_folhaCalculo);

		Form f = new Form(title());
		InputString address = new InputString(f, Message.addressRequest()); // Message - "Especifique a gama (line;col
																			// ou startline;startcol:endline;endcol): "
		f.parse();

		if (address.toString().contains(":")) { // It is a range

			Intervalo interv = pag.newIntervalo(address.toString());

			interv.copiar(entity().getCutBuffer());

			interv.apagar();

		} else { // It is a cell

			Cell cell = pag.newCell(address.toString());

			if (cell != null) {
				if (cell.getConteudo() == "") { // It means that the cell has a literal content
					new Cell(_folhaCalculo, entity().getCutBuffer(), 1, cell.getValor());
				} else { // It means that the cell has a content that is not literal
					new Cell(_folhaCalculo, entity().getCutBuffer(), 1, cell.getConteudo());
				}
				_folhaCalculo.removeCell(cell.getId());
			} else {
				entity().getCutBuffer().addNullCell(1);
			}
		}
	}

}
