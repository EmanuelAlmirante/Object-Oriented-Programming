package calc.menu.edit;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import calc.textui.edit.InvalidCellRange;
import calc.textui.edit.MenuEntry;
import calc.textui.edit.Message;
import calc.core.*;

/**
 * Class that allows the visualization of the contents of a range specified.
 */
public class Visualizar extends Command<AppCalc> {

	FolhaCalculo _folhaCalculo;

	/**
	 * Constructor.
	 * 
	 * @param
	 * 
	 */
	public Visualizar(AppCalc app) {
		super(MenuEntry.SHOW, app);

	}

	/**
	 * Executes the command.
	 * 
	 * @throws InvalidCellRange
	 * 
	 * @throws InvalidOperation
	 */
	@Override
	public final void execute() throws InvalidCellRange {
		_folhaCalculo = entity().getFolhaCalculo();
		Form f = new Form(title());
		InputString address = new InputString(f, Message.addressRequest()); // Message - "Especifique a gama (line;col
																			// ou startline;startcol:endline;endcol): "
		f.parse();
		ParseAndGenerator pag = new ParseAndGenerator(_folhaCalculo);

		if (address.toString().contains(":")) {

			Intervalo interv = pag.newIntervalo(address.toString());

			Display d = new Display(title());
			for (Integer id : interv.getList()) {
				Cell tempCell = _folhaCalculo.getCellById(id);
				if (tempCell != null) {
					d.addNewLine(tempCell.toString());
				} else {/* Dummy print */
					d.addNewLine((((id - 1) / (_folhaCalculo.getColunasTotais())) + 1) + ";"
							+ (((id - 1) % (_folhaCalculo.getColunasTotais())) + 1) + "|");
				}
			}
			d.display();

		} else {

			// Cell cell = pag.newCell(entity().getFolhaCalculo(), address.toString());
			String ags[] = address.toString().split("\\;");

			int linha = Integer.parseInt(ags[0]);
			int coluna = Integer.parseInt(ags[1]);

			Cell cell = entity().getFolhaCalculo().getCellByPos(linha, coluna);

			if (cell != null) {
				(new Display(title())).add(linha + ";" + coluna + "|" + cell.getValor() + cell.getConteudo()).display();
			} else {
				(new Display(title())).add(linha + ";" + coluna + "|").display();
			}

		}

	}
}
