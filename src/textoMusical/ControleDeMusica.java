package textoMusical;
import java.io.File;
import java.io.IOException;

import org.jfugue.Player;


public class ControleDeMusica {
	private ConversorTextoMusica conversor;
	private Player player = new Player();
	
	public ControleDeMusica(EntradaDeTexto entradaTexto) {
		conversor = new ConversorTextoMusica(entradaTexto);
	}
	
	public void tocarMusica() {
		String textoConvertidoEmSequencia = conversor.converterTextoParaSequencia();

		player.play(textoConvertidoEmSequencia);

	}
	
	public void salvarMIDI(File arquivo) {
		String textoConvertidoEmSequencia = conversor.converterTextoParaSequencia();
		try {
			player.saveMidi(textoConvertidoEmSequencia, arquivo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void pararMusica() {
		player.stop();
	}
	
	public void pausarMusica() {
		player.pause();
	}
	
	public void voltarMusica() {
		this.pararMusica();
		this.tocarMusica();
	}
}
