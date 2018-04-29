package calc.core.functions.intervalo;

import calc.core.Cell;
import calc.core.Intervalo;

public class Avg extends FuncaoIntervalo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Avg(Intervalo interv) {
		_startline = interv.getStartline();
		_startcol = interv.getStartcol();
		_endline = interv.getEndline();
		_endcol = interv.getEndcol();
		_folha = interv.getFolhaCalculo();
		execute();
	}

	public void execute() {
		int sum = 0;

		if (_startline == _endline) {
			for (int i = _startcol; i <= _endcol; i++) {
				Cell cell = _folha.getCellByPos(_startline, i);
				if (cell != null && cell.getValor() != "#VALUE") {
					sum += Integer.parseInt(cell.getValor());
				} else {
					setConteudo("#VALUE");
					return;
				}
			}
			setConteudo("" + (sum / (_endcol - _startcol + 1)));
		} else if (_startcol == _endcol) {
			for (int i = _startline; i <= _endline; i++) {
				Cell cell = _folha.getCellByPos(i, _startcol);
				if (cell != null && cell.getValor() != "#VALUE") {
					sum += Integer.parseInt(cell.getValor());
				} else {
					setConteudo("#VALUE");
					return;
				}
			}
			setConteudo("" + sum / (_endline - _startline + 1));
		}

	}
}
