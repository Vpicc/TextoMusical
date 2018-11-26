package textoMusical;
import java.io.*;


import javax.swing.JOptionPane;

import org.jfugue.Player;

public class Arquivo {
	String arquivoAberto;
	EntradaDeTexto entradaTexto;
	ConversorTextoMusica conversor;
	Player player = new Player();
	
	public Arquivo(EntradaDeTexto entradaTexto) {
		this.entradaTexto = entradaTexto;
		conversor = new ConversorTextoMusica(entradaTexto);
	}
	
	public EntradaDeTexto getEntradaTexto() {
		return entradaTexto;
	}
	
	public void setEntradaTexto(EntradaDeTexto entradaTexto) {
		this.entradaTexto = entradaTexto;
	}
	
	public void abrir(File arquivo) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(arquivo.getPath()));
			String buffer = "";
			String linha = "";
			while((linha=br.readLine()) != null) {
				buffer += linha;
			}
			entradaTexto.setCaixaDeTexto(buffer);
			if (br != null) {
				br.close();
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}
	
	public void salvar() {
		try(PrintWriter saida = new PrintWriter(arquivoAberto)) {
			saida.print(entradaTexto.getCaixaDeTexto());
		} catch (FileNotFoundException e) {
			System.out.println("\nArquivo n�o encontrado!\n");
			return;
		}	
	}
	
	public void salvarComo(File arquivo) {
		String conteudo = entradaTexto.getCaixaDeTexto();
		try {
			FileWriter fw = new FileWriter(arquivo.getPath()+".txt");
			fw.write(conteudo);
			fw.flush();
			fw.close();
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
		
	}
	
	public void salvarMIDI(File arquivo) {
		String textoConvertidoEmSequencia = conversor.converterTextoParaSequencia();
		try {
			player.saveMidi(textoConvertidoEmSequencia, arquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

