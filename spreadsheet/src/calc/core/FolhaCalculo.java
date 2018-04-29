package calc.core;

import java.io.*;
import java.util.Map;

/**
 * This class saves and opens mains.
 *
 * @author Object-Oriented Programming
 * @version 1.0.0
 *
 **********/

public class FolhaCalculo implements Serializable {

	/**
	 * Serial number for serialization.
	 */
	private static final long serialVersionUID = 6525382032511252923L;

	// Name of the spreadsheet
	private String _nomefolha = "";

	// Cells
	private HashMapType _hashMapType = new HashMapType(this);

	// Total number of lines of the spreadsheet
	int _linhasTotais;

	// Total number of columns of the spreadsheet
	int _colunasTotais;

	// Used for searches
	public Map<Integer, Cell> getCells() {
		return _hashMapType.getCells();
	}

	public int getLinhasTotais() {
		return _linhasTotais;
	}

	public int getColunasTotais() {
		return _colunasTotais;
	}

	public String getNomeFolha() {
		return _nomefolha;
	}

	public void setNomeFolha(String nome) {
		_nomefolha = nome;
	}

	/**
	 * Construtor.
	 * 
	 * @param
	 * 
	 */
	public FolhaCalculo(AppCalc app, int linhasTotais, int colunasTotais) {
		_linhasTotais = linhasTotais;
		_colunasTotais = colunasTotais;
		app.setFolhaCalc(this);
	}

	/**
	 * Receives a cell and saves it.
	 * 
	 * @param Cell
	 * 
	 * 
	 * @return identifier of the cell
	 */
	public int addCell(Cell cell) {
		return _hashMapType.addCell(cell);
	}

	/**
	 * Returns a cell given an ID.
	 * 
	 * @param id
	 * 
	 * @return the cell or null if the ID does not identify a valid cell
	 * 
	 */
	public Cell getCellById(int id) {
		return _hashMapType.getCellById(id);
	}

	/**
	 * Returns a cell given a line and a column.
	 * 
	 * @param id
	 * 
	 * @return the cell or null if the line and column do not identify a valid cell
	 * 
	 */
	public Cell getCellByPos(int linha, int coluna) {
		return _hashMapType.getCellByPos(linha, coluna);
	}

	/**
	 * @param cell
	 *
	 */
	public void removeCell(int id) {
		_hashMapType.removeCell(id);
	}

	public void removeCellByPos(int linha, int coluna) {
		_hashMapType.removeCellByPos(linha, coluna);
	}

}
