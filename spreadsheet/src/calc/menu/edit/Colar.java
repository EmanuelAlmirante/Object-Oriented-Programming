package calc.menu.edit;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import calc.textui.edit.InvalidCellRange;
import calc.textui.edit.MenuEntry;
import calc.textui.edit.Message;
import calc.core.*;

public class Colar extends Command<AppCalc> {

	private FolhaCalculo _folhaCalculo;
	private CutBuffer _cutBuffer;

	/**
	 * Constructor.
	 * 
	 * @param app
	 * 
	 */
	public Colar(AppCalc app) {
		super(MenuEntry.PASTE, app);
	}

	@Override
	public final void execute() throws InvalidCellRange {

		_folhaCalculo = entity().getFolhaCalculo();
		_cutBuffer = entity().getCutBuffer();

		if (!entity().getCutBuffer().isEmpty()) {
			Form f = new Form(title());
			InputString address = new InputString(f, Message.addressRequest()); // Message - "Especifique a gama
																				// (line;col ou
																				// startline;startcol:endline;endcol): "
			f.parse();
			ParseAndGenerator pag = new ParseAndGenerator(_folhaCalculo);

			if (address.toString().contains(":")) { // It is a range

				Intervalo interv = pag.newIntervalo(address.toString());

				if (interv.getSize() == _cutBuffer.getSize()) {
					_cutBuffer.colarInterv(interv);
				}

			} else { // It is a cell

				String ags[] = address.toString().split("\\;"); // Uses ParseAndGenerator

				int linha = Integer.parseInt(ags[0]);
				int coluna = Integer.parseInt(ags[1]);

				Intervalo cellInterv = new Intervalo(_folhaCalculo, linha, coluna, linha, coluna);
				_cutBuffer.colarInterv(cellInterv);

			}
		}
	}
}