package calc.core;

import java.io.*;

/**
 *
 * @author Object-Oriented Programming
 * @version 2.1
 */

public abstract class Conteudo implements Serializable {

	/**
	 * Serial number for serialization.
	 */
	private static final long serialVersionUID = -6178402842398954519L;

	// The final value of the content of a cell is represented by this variable
	private String _valor;

	/**
	 * @return the final value of a cell
	 */

	public String getValor() {
		return _valor;
	}

	public void setConteudo(String string) {
		_valor = string;
	}

	public abstract void execute();

}
