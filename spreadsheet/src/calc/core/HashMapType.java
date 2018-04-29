package calc.core;

import java.util.HashMap;
import java.util.Map;

public class HashMapType extends GenericType {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FolhaCalculo _folhaCalculo;

	public HashMapType(FolhaCalculo folhaCalculo) {
		this._folhaCalculo = folhaCalculo;
	}

	private Map<Integer, Cell> _cells = new HashMap<Integer, Cell>();

	@Override
	public int addCell(Cell cell) {
		int cellId = cell.getId();
		_cells.put(cellId, cell);
		return cellId;
	}

	@Override
	public Cell getCellById(int id) {
		return _cells.get(id);
	}

	@Override
	public Cell getCellByPos(int linha, int coluna) {
		return _cells.get(((linha - 1) * _folhaCalculo.getColunasTotais()) + coluna);
	}

	@Override
	public void removeCell(int id) {
		_cells.remove(id);

	}

	@Override
	public void removeCellByPos(int linha, int coluna) {
		_cells.remove(((linha - 1) * _folhaCalculo.getColunasTotais()) + coluna);

	}

	@Override
	public Map<Integer, Cell> getCells() {
		return _cells;
	}

}
