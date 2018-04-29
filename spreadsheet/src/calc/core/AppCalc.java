package calc.core;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.InvalidOperation;
import calc.textui.main.Message;

/**
 *
 * 
 * @author Object-Oriented Programming
 * @version 2.1
 */

public class AppCalc {

	// The spreadsheet
	private FolhaCalculo _folhaCalculo;

	/**
	 * If this spreadsheet was populated with imported information this variable is
	 * true
	 */
	private boolean _folhaImportada = false;

	// Buffer used by the application to copy, cut and paste
	CutBuffer _cutBuffer = new CutBuffer();

	public FolhaCalculo getFolhaCalculo() {
		return _folhaCalculo;
	}

	public boolean getFolhaImported() {
		return _folhaImportada;
	}

	public CutBuffer getCutBuffer() {
		return _cutBuffer;
	}

	public String getNomeFolha() {
		return _folhaCalculo.getNomeFolha();
	}

	public void setFolhaCalc(FolhaCalculo folha) {
		_folhaCalculo = folha;
	}

	public void setNomeFolha(String nome) {
		_folhaCalculo.setNomeFolha(nome);
	}

	public void save(String nomeFile) throws IOException {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeFile));
			out.writeObject(_folhaCalculo);
			out.close();
		} catch (IOException e) {
			System.out.println(e);
		}

	}

	public void load(String nomeFile) throws InvalidOperation {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeFile));
			_folhaCalculo = (FolhaCalculo) in.readObject();
			in.close();
		} catch (Exception e) {
			(new Display()).add(Message.fileNotFound(nomeFile)).display();
			System.out.println(e);
		}
	}

	public void parseInputFile(String filename) throws IOException {
		int lineno = 0;
		_folhaImportada = true;
		try {
			@SuppressWarnings("resource")
			BufferedReader in = new BufferedReader(new FileReader(filename));
			String s;
			int linha = 0;
			int coluna = 0;

			while ((s = in.readLine()) != null) {
				String line = new String(s.getBytes(), "UTF-8");
				lineno++;
				// Parse of the line and the column, to creat the spreadsheet
				if (lineno == 1) {
					String Slinha[] = line.split("\\=");
					linha = Integer.parseInt(Slinha[1]);
				} else if (lineno == 2) {
					String Scoluna[] = line.split("\\=");
					coluna = Integer.parseInt(Scoluna[1]);
					_folhaCalculo = new FolhaCalculo(this, linha, coluna);
				} else {

					String[] split = line.split("\\|");

					// Creates a new cell
					String cellPos[] = split[0].split("\\;");
					int cellLinha = Integer.parseInt(cellPos[0]);
					int cellColuna = Integer.parseInt(cellPos[1]);
					Cell newCell = new Cell(_folhaCalculo, cellLinha, cellColuna, split[1]);
					_folhaCalculo.addCell(newCell);
				}

			}
		} catch (FileNotFoundException e) {
			System.out.println("Erro (file not found):" + filename + ": " + e);
		}

	}

}
