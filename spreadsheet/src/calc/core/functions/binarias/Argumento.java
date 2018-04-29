package calc.core.functions.binarias;

import calc.core.Cell;
import calc.core.FolhaCalculo;
import java.io.*;

public class Argumento implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	// Literal value of the argument
	public String _valor;
	private FolhaCalculo _folhaCalculo;
	String _argumento;

	public Argumento(FolhaCalculo folha, String argumento) {

		_folhaCalculo = folha;
		_argumento = argumento;

	}

	public String getValor() {
		if (_argumento.contains(";")) { // Is a reference
			String ags[] = _argumento.split("\\;");
			int linha = Integer.parseInt(ags[0]);
			int coluna = Integer.parseInt(ags[1]);

			Cell tempCell = _folhaCalculo.getCellByPos(linha, coluna);
			if (tempCell != null) {
				_valor = tempCell.getValor();
			} else {
				_valor = "#VALUE";
			}

		} else { // Is literal

			_valor = _argumento;
		}

		return _valor;
	}

}
