package calc.core.functions.binarias;

/**
 *
 * @author Object-Oriented Programming
 * @version 2.1
 */

public class Sub extends FuncaoBinaria {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	public Sub(Argumento arg1, Argumento arg2) {

		_arg1 = arg1;
		_arg2 = arg2;
		execute();

	}

	@Override
	public void execute() {

		if (_arg1.getValor() == "#VALUE" || _arg2.getValor() == "#VALUE") {
			setConteudo("#VALUE");
		} else {
			setConteudo("" + (Integer.parseInt(_arg1.getValor()) - Integer.parseInt(_arg2.getValor())));
		}
	}
}