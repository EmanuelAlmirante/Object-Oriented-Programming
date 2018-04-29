package calc.core;

import java.util.*;

public class Intervalo {

	// Saves the references (IDs) of the cell of the respective range
	List<Integer> _intervaloCelulas = new ArrayList<Integer>();

	FolhaCalculo _folha;
	int _startline;
	int _startcol;
	int _endline;
	int _endcol;

	public Intervalo(FolhaCalculo folha, int startline, int startcol, int endline, int endcol) {
		_folha = folha;
		_startline = startline;
		_startcol = startcol;
		_endline = endline;
		_endcol = endcol;
		getReferencias();
	}

	public FolhaCalculo getFolhaCalculo() {
		return _folha;
	}

	public int getStartline() {
		return _startline;
	}

	public int getStartcol() {
		return _startcol;
	}

	public int getEndline() {
		return _endline;
	}

	public int getEndcol() {
		return _endcol;
	}

	private void getReferencias() {

		if (_startline == _endline && _startcol == _endcol) {
			_intervaloCelulas.add(calcCellId(_startline, _startcol));
		} else if (_startline == _endline) {
			for (int i = _startcol; i <= _endcol; i++) {
				_intervaloCelulas.add(calcCellId(_startline, i));
			}
		} else if (_startcol == _endcol) {
			for (int i = _startline; i <= _endline; i++) {
				_intervaloCelulas.add(calcCellId(i, _startcol));
			}
		}
	}

	public int getSize() {
		return _intervaloCelulas.size();
	}

	private int calcCellId(int linha, int coluna) {
		return (((linha - 1) * _folha.getColunasTotais()) + coluna);
	}

	public void setConteudo(String conteudo) {

		for (Integer id : _intervaloCelulas) {
			Cell cell = _folha.getCellById(id);
			if (cell == null) {
				new Cell(_folha, id, conteudo);
			} else {
				cell.setConteudo(conteudo);
			}
		}
	}

	public void copiar(CutBuffer cutBuffer) {
		cutBuffer.clear();
		int newId = 1;
		if (_startline == _endline) {
			cutBuffer.setOrientaco(true);
		} else {
			cutBuffer.setOrientaco(false);
		}

		for (Integer id : _intervaloCelulas) {
			Cell cell = _folha.getCellById(id);
			if (cell != null) {
				if (cell.getConteudo() == "") { // It means that the cell has a literal content
					new Cell(_folha, cutBuffer, newId, cell.getValor());
				} else { // It means that the cell has a content that is not literal
					new Cell(_folha, cutBuffer, newId, cell.getConteudo());
				}
			} else {
				cutBuffer.addNullCell(newId);
			}
			if (_startline == _endline)
				newId++;
			else
				newId += _folha.getColunasTotais();
		}
	}

	public void apagar() {
		for (Integer id : _intervaloCelulas) {
			_folha.removeCell(id);
		}
	}

	public Collection<Integer> getList() {
		return _intervaloCelulas;

	}

}
