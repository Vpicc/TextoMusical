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
			return;
		}
		entradaTexto.setCaixaDeTexto(texto);
		arquivoAberto = nomeDoArquivo;
		return;
	}
	
}

