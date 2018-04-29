package calc.textui;

import java.io.IOException;

import pt.utl.ist.po.ui.Menu;
import calc.menu.MainMenu;
import calc.core.*;

public class Calc {

	/**
	 * @param args
	 * @throws IOException
	 */
	@SuppressWarnings("nls")
	public static void main(String[] args) {
		AppCalc app = new AppCalc();

		String filename = System.getProperty("import");
		if (filename != null)
			try {
				app.parseInputFile(filename);
			} catch (IOException e) {
				e.printStackTrace();
			}

		Menu MainMenu = new MainMenu(app);
		MainMenu.open();
	}
}
