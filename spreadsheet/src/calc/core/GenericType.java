package calc.core;

import java.io.Serializable;

public abstract class GenericType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract int addCell(Cell cell);

	public abstract Cell getCellById(int id);

	public abstract Cell getCellByPos(int linha, int coluna);

	public abstract void removeCell(int id);

	public abstract void removeCellByPos(int linha, int coluna);

	public abstract Object getCells();
}
