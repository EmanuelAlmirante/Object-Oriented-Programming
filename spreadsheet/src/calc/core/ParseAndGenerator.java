package calc.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calc.core.functions.binarias.Add;
import calc.core.functions.binarias.Argumento;
import calc.core.functions.binarias.Div;
import calc.core.functions.binarias.Mul;
import calc.core.functions.binarias.Sub;
import calc.core.functions.intervalo.Avg;
import calc.core.functions.intervalo.Prd;
import calc.textui.edit.InvalidCellRange;

public class ParseAndGenerator {

	private FolhaCalculo _folhaCalculo;

	public ParseAndGenerator(FolhaCalculo folhadCalculo) {
		this._folhaCalculo = folhadCalculo;
	}

	public Intervalo newIntervalo(String address) throws InvalidCellRange {

		String ags[] = address.split(";|\\:");

		int startline = Integer.parseInt(ags[0]);
		int startcol = Integer.parseInt(ags[1]);
		int endline = Integer.parseInt(ags[2]);
		int endcol = Integer.parseInt(ags[3]);

		if (startline > _folhaCalculo.getLinhasTotais() || endline > _folhaCalculo.getLinhasTotais()
				|| startcol > _folhaCalculo.getColunasTotais() || endcol > _folhaCalculo.getColunasTotais()) {
			throw new InvalidCellRange(address);
		}

		if (!(startcol == endcol || startline == endline))
			throw new InvalidCellRange(address);

		Intervalo interv = new Intervalo(_folhaCalculo, startline, startcol, endline, endcol);
		return interv;

	}

	public Conteudo newConteudo(String conteudo) {

		if (conteudo.contains("=") && conteudo.contains("(")) {// e uma funcao binaria

			String pattern = "\\((.*?)\\)";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(conteudo);
			m.find();
			String argumentos = m.group(1);

			Argumento arg1 = null;
			Argumento arg2 = null;
			int startline = 0;
			int startcol = 0;
			int endline = 0;
			int endcol = 0;
			String args[];

			if (argumentos.contains(",")) {
				args = argumentos.split("\\,");
				arg1 = new Argumento(_folhaCalculo, args[0]);
				arg2 = new Argumento(_folhaCalculo, args[1]);
			} else {
				args = argumentos.toString().split(";|\\:");
				startline = Integer.parseInt(args[0]);
				startcol = Integer.parseInt(args[1]);
				endline = Integer.parseInt(args[2]);
				endcol = Integer.parseInt(args[3]);
			}

			if (conteudo.contains("ADD")) {
				return new Add(arg1, arg2);
			}

			if (conteudo.contains("SUB")) {
				return new Sub(arg1, arg2);
			}

			if (conteudo.contains("MUL")) {
				return new Mul(arg1, arg2);
			}

			if (conteudo.contains("DIV")) {
				return new Div(arg1, arg2);
			}

			if (conteudo.contains("AVG")) {
				Intervalo interv = new Intervalo(_folhaCalculo, startline, startcol, endline, endcol);
				return new Avg(interv);
			}

			if (conteudo.contains("PRD")) {
				Intervalo interv = new Intervalo(_folhaCalculo, startline, startcol, endline, endcol);
				return new Prd(interv);
			}

		} else if (conteudo.contains("=")) { // The content is a reference

			String ags2[] = conteudo.split("[=;]+");

			int linha = Integer.parseInt(ags2[1]);
			int coluna = Integer.parseInt(ags2[2]);
			return new ConteudoReferencia(_folhaCalculo, linha, coluna);

		} else { // The content is a literal
			return new ConteudoLiteral(conteudo);
		}
		return null;

	}

	public Cell newCell(String address) throws InvalidCellRange {

		String ags[] = address.split("\\;");

		int linha = Integer.parseInt(ags[0]);
		int coluna = Integer.parseInt(ags[1]);

		if (linha > _folhaCalculo.getLinhasTotais() || coluna > _folhaCalculo.getColunasTotais())
			throw new InvalidCellRange(address);

		Cell cell = _folhaCalculo.getCellByPos(linha, coluna);
		return cell;
	}
}
