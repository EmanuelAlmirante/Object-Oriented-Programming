package calc.menu;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Display;
import calc.menu.edit.EditMenu;
import calc.menu.search.SearchMenu;
import calc.textui.main.MenuEntry;
import calc.core.*;

/**
 * This class represents the main menu of the application.
 *
 * @author Object-Oriented Programming
 * @version 1.0
 */
public class MainMenu extends Menu {

	/**
	 * Constructor for class MainMenu
	 * 
	 * @param
	 */
	public MainMenu(AppCalc app) {
		super(MenuEntry.TITLE, new Command<?>[] {

				new CriarFolhaCalculo(app), // New

				new Abrir(app),

				new Guardar(app),

				new Command<AppCalc>(MenuEntry.SAVE_AS, app) {
					public final void execute() {
					}
				},

				new Command<AppCalc>(MenuEntry.MENU_CALC, app) {
					public final void execute() {
						FolhaCalculo folha = entity().getFolhaCalculo();
						if (folha == null)
							(new Display(title())).add("Nao foi selccionada nenhuma folha").display();
						else {
							Menu m = new EditMenu(entity());
							m.open();
						}
					}
				},

				new Command<AppCalc>(MenuEntry.MENU_SEARCH, app) {
					public final void execute() {
						Menu m = new SearchMenu(entity());
						m.open();
					}
				}

		});
		if (!app.getFolhaImported()) {
			entry(2).invisible();
			entry(3).invisible();
			entry(4).invisible();
			entry(5).invisible();
		}
	}

}
