package calc.core.functions.intervalo;

import calc.core.Cell;
import calc.core.Intervalo;

public class Prd extends FuncaoIntervalo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Prd(Intervalo interv) {
		_startline = interv.getStartline();
		_startcol = interv.getStartcol();
		_endline = interv.getEndline();
		_endcol = interv.getEndcol();
		_folha = interv.getFolhaCalculo();
		execute();
	}

	public void execute() {
		int prd = 1;

		if (_startline == _endline) {
			for (int i = _startcol; i <= _endcol; i++) {
				Cell cell = _folha.getCellByPos(_startline, i);
				if (cell != null && cell.getValor() != "#VALUE") {
					prd *= Integer.parseInt(cell.getValor());
				} else {
					setConteudo("#VALUE");
					return;
				}
			}
			setConteudo("" + prd);
		} else if (_startcol == _endcol) {
			for (int i = _startline; i <= _endline; i++) {
				Cell cell = _folha.getCellByPos(i, _startcol);
				if (cell != null && cell.getValor() != "#VALUE") {
					prd *= Integer.parseInt(cell.getValor());
				} else {
					setConteudo("#VALUE");
					return;
				}
			}
			setConteudo("" + prd);
		}

	}
}