package calc.core;

import java.io.*;

/**
 *
 * @author Object-Oriented Programming
 * @version 2.1
 */

public class Cell implements Serializable {

	/**
	 * Serial number for serialization.
	 */
	private static final long serialVersionUID = 5310580630941209124L;

	// The identifier of this cell
	private int _id;

	// The spreadsheet of the cell
	private FolhaCalculo _folhaCalculo;

	// The content of the respective cell
	private Conteudo _conteudo;

	private String _stringConteudo;

	private int _linha;

	private int _coluna;

	/**
	 * @return the ID of the cell
	 */
	public final int getId() {
		return _id;
	}

	public int getLinha() {
		return _linha;
	}

	public int getColuna() {
		return _coluna;
	}

	public Cell(FolhaCalculo folhaCalculo, int linha, int coluna, String conteudo) {
		_linha = linha;
		_coluna = coluna;
		_id = (((linha - 1) * folhaCalculo.getColunasTotais())
				+ coluna); /* Formula: [CellLinha - 1]*Total de linhas + CellColuna */
		(_folhaCalculo = folhaCalculo).addCell(this);
		setConteudo(conteudo);
	}

	public Cell(FolhaCalculo folhaCalculo, int id, String conteudo) {
		_linha = ((id - 1) / (folhaCalculo.getColunasTotais())) + 1;
		_coluna = ((id - 1) % (folhaCalculo.getColunasTotais())) + 1;
		_id = id;
		(_folhaCalculo = folhaCalculo).addCell(this);
		setConteudo(conteudo);
	}

	public Cell(FolhaCalculo folhaCalculo, CutBuffer cutBuffer, int id, String conteudo) { // para o cut buffer
		_linha = ((id - 1) / (folhaCalculo.getColunasTotais())) + 1;
		_coluna = ((id - 1) % (folhaCalculo.getColunasTotais())) + 1;
		_id = id;
		_folhaCalculo = folhaCalculo;
		cutBuffer.addCell(this);
		setConteudo(conteudo);
	}

	public String getConteudo() {
		return _stringConteudo;
	}

	public String getValor() {
		_conteudo.execute(); // Updates
		return _conteudo.getValor();
	}

	public void setConteudo(String conteudo) {

		_stringConteudo = "";
		if (conteudo.contains("=")) {
			_stringConteudo = conteudo;
		}
		ParseAndGenerator pag = new ParseAndGenerator(_folhaCalculo);
		_conteudo = pag.newConteudo(conteudo);

	}

	public String toString() {
		return _linha + ";" + _coluna + "|" + getValor() + getConteudo();
	}

}
