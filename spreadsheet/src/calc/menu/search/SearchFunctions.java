package calc.menu.search;

import java.util.Map;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import calc.core.AppCalc;
import calc.core.Cell;
import calc.core.FolhaCalculo;
import calc.textui.search.Message;
import calc.textui.search.MenuEntry;

public class SearchFunctions extends Command<AppCalc> {
	FolhaCalculo _folhaCalculo;

	public SearchFunctions(AppCalc app) {
		super(MenuEntry.SEARCH_FUNCTIONS, app);
	}

	@Override
	public final void execute() {
		_folhaCalculo = entity().getFolhaCalculo();
		Form f = new Form(title());
		InputString arg = new InputString(f, Message.searchFunction()); // Message - "Especifique a gama (line;col ou
																		// startline;startcol:endline;endcol): "
		f.parse();

		Display d = new Display(title());
		Map<Integer, Cell> hm = _folhaCalculo.getCells();
		for (Integer id : hm.keySet()) {
			Cell tempCell = _folhaCalculo.getCellById(id);
			if (tempCell.getConteudo().contains(arg.toString())) {
				d.addNewLine(tempCell.toString());
			}
		}
		d.display();

	}

}
