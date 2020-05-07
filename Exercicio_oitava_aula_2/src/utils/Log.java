package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Log {
	public static final String NOME = "rastreamento.txt";
	private PrintWriter arquivo;

	public void abrir(String nome) throws IOException {
		
		// File outFile = new File(nome);
		// FileOutputStream outFileStream;
	//	File outFile = new File("C:\\Users\\leopd\\eclipse-workspace\\Exercicio_oitava_aula_2\\WebContent\\log",nome);
	//	File arquivo = new File("C:/notas/logs","arquivo.log");
		File outFile = new File("C:\\Users\\leopd\\eclipse-workspace\\Exercicio_oitava_aula_2\\WebContent\\log",NOME);
        FileOutputStream outFileStream;
			
		System.out.println("Procure o arquivo em " + nome);
		if (outFile.exists()) {
			outFileStream = new FileOutputStream(outFile, true);
			System.out.println("achei arquivo aqui 1");
		} else {
			outFileStream = new FileOutputStream(outFile);
			System.out.println("não achei arquivo aqui 2");
		}
		arquivo = new PrintWriter(outFileStream);
	}

	public void escrever(String texto) throws IOException {
		arquivo.println(texto);
		arquivo.flush();
	}

	public void fechar() throws IOException {
		arquivo.close();
	}

}