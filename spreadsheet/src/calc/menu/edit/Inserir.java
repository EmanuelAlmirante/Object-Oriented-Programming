package calc.menu.edit;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

import calc.textui.edit.InvalidCellRange;
import calc.textui.edit.MenuEntry;
import calc.textui.edit.Message;
import calc.core.*;

/**
 * Class that allows to insert content in a specified range.
 */
public class Inserir extends Command<AppCalc> {

	private FolhaCalculo _folhaCalculo;

	/**
	 * Constructor.
	 * 
	 * @param 
	 *            
	 */
	public Inserir(AppCalc app) {
		super(MenuEntry.INSERT, app);
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
		InputString conteudo = new InputString(f, Message.contentsRequest()); // Message - "Insira o conteudo da celula:
																				// "
		f.parse();
		ParseAndGenerator pag = new ParseAndGenerator(_folhaCalculo);

		if (address.toString().contains(":")) { // Insertion in a specified range

			Intervalo interv = pag.newIntervalo(address.toString());

			interv.setConteudo(conteudo.toString());

		} else { // Insertation in a cell

			String ags[] = address.toString().split("\\;");

			int linha = Integer.parseInt(ags[0]);
			int coluna = Integer.parseInt(ags[1]);

			Cell cell = _folhaCalculo.getCellByPos(linha, coluna);

			if (cell != null) {

				cell.setConteudo(conteudo.toString());

			} else {
				new Cell(_folhaCalculo, linha, coluna, conteudo.toString());
			}
		}

	}
}
