package textoMusical;
import org.jfugue.Player;


public class ControleDeMusica {
	private ConversorTextoMusica conversor;
	private Player player = new Player();
	
	public ControleDeMusica(EntradaDeTexto entradaTexto) {
		conversor = new ConversorTextoMusica(entradaTexto);
	}
	
	public void tocarMusica() {
		String textoConvertidoEmSequencia = conversor.converterTextoParaSequencia();
		System.out.println(textoConvertidoEmSequencia);
		player.play(textoConvertidoEmSequencia);
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
