package calc.menu;

import java.io.IOException;
import calc.textui.main.Message;
import calc.textui.main.MenuEntry;
import calc.core.*;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Class <code>Save</code> represents a command to save the current state of
 * application in the file associated to the application.
 *
 * @version 1.0
 * @author PO
 **/

public class Guardar extends Command<AppCalc> {
	/**
	 */
	public Guardar(AppCalc app) {
		super(MenuEntry.SAVE, app);
	}

	@Override
	public final void execute() throws InvalidOperation {
		if (entity().getNomeFolha().equals("")) {
			Form f = new Form(title());
			InputString nome = new InputString(f, Message.newSaveAs());
			f.parse();
			try {
				entity().save(nome.value());
			} catch (IOException e) {
				System.out.println("ERRO: " + e);
			}
			entity().setNomeFolha(nome.toString());
		}
		try {
			entity().save(entity().getNomeFolha());
		} catch (IOException m) {
			System.out.println("ERRO: " + m);
		}
	}
}
