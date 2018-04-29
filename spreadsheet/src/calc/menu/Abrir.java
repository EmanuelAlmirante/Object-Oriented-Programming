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

public class Abrir extends Command<AppCalc> {

	public Abrir(AppCalc app) {
		super(MenuEntry.OPEN, app);
	}

	@Override
	public final void execute() throws InvalidOperation {
		Form d = new Form(title());
		if (entity().getFolhaImported()) {
			Form f = new Form(title());
			InputString userResposta = new InputString(f, Message.saveBeforeExit());
			f.parse();

			if (userResposta.toString().contains("s")) {
				if (entity().getNomeFolha().equals("")) {
					Form r = new Form(title());
					InputString nome = new InputString(r, Message.newSaveAs());
					r.parse();
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

		InputString nomeFicheiro = new InputString(d, Message.openFile());
		d.parse();
		entity().load(nomeFicheiro.value());
		menu().entry(2).visible();
		menu().entry(3).visible();
		menu().entry(4).visible();
		menu().entry(5).visible();

	}

}
