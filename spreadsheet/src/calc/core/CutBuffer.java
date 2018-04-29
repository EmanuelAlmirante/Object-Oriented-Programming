package calc.core;

import java.util.LinkedHashMap;
import java.util.Map;

public class CutBuffer {

	private Map<Integer, Cell> _bufferCells = new LinkedHashMap<Integer, Cell>();

	private boolean _orientacao; // True if it is a line, false if it is a column.

	public void setOrientaco(boolean arg) {
		_orientacao = arg;
	}

	public int addCell(Cell cell) {
		int cellId = cell.getId();
		_bufferCells.put(cellId, cell);
		return cellId;
	}

	public int addNullCell(int id) {
		_bufferCells.put(id, null);
		return id;
	}

	public void clear() {
		_bufferCells.clear();
	}

	public boolean isEmpty() {
		return _bufferCells.isEmpty();
	}

	public int getSize() {
		return _bufferCells.size();
	}

	public void colarInterv(Intervalo interv) {
		FolhaCalculo folhaCalculo = interv.getFolhaCalculo();
		int linha = interv.getStartline();
		int coluna = interv.getStartcol();

		if (interv.getStartline() == interv.getEndline() && interv.getStartcol() == interv.getEndcol()) {
			if (_orientacao) { // Line
				for (Integer key : _bufferCells.keySet()) {
					Cell cell = _bufferCells.get(key);
					folhaCalculo.removeCellByPos(linha, coluna);
					if (cell != null) {
						if (cell.getConteudo() == "") { // It means that the cell has a literal content
							new Cell(folhaCalculo, linha, coluna, cell.getValor());
						} else { // It means that the cell has a content that is not literal
							new Cell(folhaCalculo, linha, coluna, cell.getConteudo());
						}
					}
					coluna++;
					if (coluna > interv.getFolhaCalculo().getColunasTotais())
						return;
				}
			} else { // Column
				for (Integer key : _bufferCells.keySet()) {
					Cell cell = _bufferCells.get(key);
					folhaCalculo.removeCellByPos(linha, coluna);
					if (cell != null) {
						if (cell.getConteudo() == "") { // It means that the cell has a literal content
							new Cell(folhaCalculo, linha, coluna, cell.getValor());
						} else { // It means that the cell has a content that is not literal
							new Cell(folhaCalculo, linha, coluna, cell.getConteudo());
						}
					}
					linha++;
					if (linha > interv.getFolhaCalculo().getLinhasTotais())
						return;
				}
			}
		}

		if (interv.getStartline() == interv.getEndline()) { // Pastes into a line
			for (Integer key : _bufferCells.keySet()) {
				Cell cell = _bufferCells.get(key);
				folhaCalculo.removeCellByPos(linha, coluna);
				if (cell != null) {
					if (cell.getConteudo() == "") { // It means that the cell has a literal content
						new Cell(folhaCalculo, linha, coluna, cell.getValor());
					} else { // It means that the cell has a content that is not literal
						new Cell(folhaCalculo, linha, coluna, cell.getConteudo());
					}
				}
				coluna++;
			}
		} else if (interv.getStartcol() == interv.getEndcol()) { // Pastes into a column
			for (Integer key : _bufferCells.keySet()) {
				Cell cell = _bufferCells.get(key);
				folhaCalculo.removeCellByPos(linha, coluna);
				if (cell != null) {
					if (cell.getConteudo() == "") { // It means that the cell has a literal content
						new Cell(folhaCalculo, linha, coluna, cell.getValor());
					} else { // It means that the cell has a content that is not literal
						new Cell(folhaCalculo, linha, coluna, cell.getConteudo());
					}
				}
				linha++;
			}
		}

	}

	public Map<Integer, Cell> getBuffer() {
		return _bufferCells;
	}

}
