package calc.menu.edit;

import java.util.Map;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Display;

import calc.textui.edit.MenuEntry;
import calc.core.*;

public class EditMenu extends Menu {

	/**
	 * Constructor for class BankMenu
	 *
	 * @param b
	 *            the bank this account belongs to.
	 */
	public EditMenu(AppCalc app) {
		super(MenuEntry.TITLE, new Command<?>[] {

				new Visualizar(app), new Inserir(app), new Copiar(app), new Apagar(app), new Cut(app), new Colar(app),
				new Command<AppCalc>(MenuEntry.SHOW_CUT_BUFFER, app) {
					public final void execute() {
						Display d = new Display(title());
						Map<Integer, Cell> hm = entity().getCutBuffer().getBuffer();
						for (Integer id : hm.keySet()) {
							if (hm.get(id) != null) {
								d.addNewLine(hm.get(id).toString());
							} else {
								d.addNewLine(((id - 1) / ((entity().getFolhaCalculo().getColunasTotais())) + 1) + ";"
										+ ((id - 1) % ((entity().getFolhaCalculo().getColunasTotais())) + 1) + "|");
							}
						}
						d.display();
					}
				}

		});
	}

}
