package calc.menu;

import java.io.IOException;

import calc.textui.main.Message;
import calc.textui.main.MenuEntry;
import calc.core.*;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Class to create a new a new spreadsheet.
 * 
 * @version 1.0
 */
public class CriarFolhaCalculo extends Command<AppCalc> {
	/**
	 * Constructor.
	 * 
	 * @param
	 * 
	 */
	public CriarFolhaCalculo(AppCalc app) {
		super(MenuEntry.NEW, app);
	}

	/**
	 * Executes the command.
	 * 
	 * @throws InvalidOperation
	 */

	@Override
	public void execute() throws InvalidOperation {
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

		InputInteger linhas = new InputInteger(d, Message.linesRequest());
		InputInteger colunas = new InputInteger(d, Message.columnsRequest());
		d.parse();
		new FolhaCalculo(entity(), linhas.value(), colunas.value());
		menu().entry(2).visible();
		menu().entry(3).visible();
		menu().entry(4).visible();
		menu().entry(5).visible();

	}

}
