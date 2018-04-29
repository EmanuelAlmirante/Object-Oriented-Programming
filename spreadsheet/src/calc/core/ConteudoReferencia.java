package calc.core;

/**
 *
 * @author Object-Oriented Programming
 * @version 2.1
 */

public class ConteudoReferencia extends Conteudo {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	FolhaCalculo _folha;
	int _cellLinhaRef;
	int _cellColunaRef;

	public ConteudoReferencia(FolhaCalculo folha, int cellLinhaRef, int cellColunaRef) {

		_folha = folha;
		_cellLinhaRef = cellLinhaRef;
		_cellColunaRef = cellColunaRef;
		execute();

	}

	@Override
	public void execute() {
		Cell tempCell = _folha.getCellByPos(_cellLinhaRef, _cellColunaRef);
		if (tempCell != null) {
			setConteudo(_folha.getCellByPos(_cellLinhaRef, _cellColunaRef).getValor());
		} else {
			setConteudo("#VALUE");
		}

	}

}
