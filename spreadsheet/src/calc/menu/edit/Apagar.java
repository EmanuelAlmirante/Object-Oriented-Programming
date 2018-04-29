package calc.menu.edit;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import calc.core.AppCalc;
import calc.core.Cell;
import calc.core.FolhaCalculo;
import calc.core.Intervalo;
import calc.core.ParseAndGenerator;
import calc.textui.edit.InvalidCellRange;
import calc.textui.edit.MenuEntry;
import calc.textui.edit.Message;

public class Apagar extends Command<AppCalc> {

	private FolhaCalculo _folhaCalculo;

	/**
	 * Constructor.
	 * 
	 * @param
	 * 
	 */
	public Apagar(AppCalc app) {
		super(MenuEntry.DELETE, app);
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

		if (address.toString().contains(":")) { // It is an insertation in a range

			Intervalo interv = pag.newIntervalo(address.toString());
			interv.apagar();

		} else { // It is an insertation in a cell

			Cell cell = pag.newCell(address.toString());

			if (cell != null) {
				_folhaCalculo.removeCell(cell.getId());
			}

		}
	}

}
