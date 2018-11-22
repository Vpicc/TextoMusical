import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Arquivo {
	String arquivoAberto;
	EntradaDeTexto entradaTexto;
	
	public Arquivo(EntradaDeTexto entradaTexto) {
		this.entradaTexto = entradaTexto;
	}
	
	public EntradaDeTexto getEntradaTexto() {
		return entradaTexto;
	}
	
	public void setEntradaTexto(EntradaDeTexto entradaTexto) {
		this.entradaTexto = entradaTexto;
	}
	
	public void abrir(String nomeDoArquivo) {
		String texto;
		try {
			texto = new String(Files.readAllBytes(Paths.get("nomeDoArquivo")));
		} catch (IOException e) {
			System.out.println("\nFalha ao ler arquivo!\n");
			return;
		}
		entradaTexto.setCaixaDeTexto(texto);
		arquivoAberto = nomeDoArquivo;
		return;
	}
	
	public void salvar() {
		try(PrintWriter saida = new PrintWriter(arquivoAberto)) {
			saida.print(entradaTexto.getCaixaDeTexto());
		} catch (FileNotFoundException e) {
			System.out.println("\nArquivo não encontrado!\n");
			return;
		}	
	}
	
	public void salvarComo(String nomeDoArquivo) {
		try(PrintWriter saida = new PrintWriter(nomeDoArquivo)) {
			saida.print(entradaTexto.getCaixaDeTexto());
			arquivoAberto = nomeDoArquivo;
		} catch (FileNotFoundException e) {
			System.out.println("\nArquivo não encontrado!\n");
			return;
		}	
		
	}
	
}

