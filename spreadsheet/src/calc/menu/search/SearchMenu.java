package calc.menu.search;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;
import calc.textui.search.MenuEntry;
import calc.core.*;

public class SearchMenu extends Menu {

	public SearchMenu(AppCalc app) {
		super(MenuEntry.TITLE, new Command<?>[] {

				new SearchValores(app), new SearchFunctions(app)

		});
	}

}
