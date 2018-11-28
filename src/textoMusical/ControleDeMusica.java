package textoMusical;

import org.jfugue.Player;


public class ControleDeMusica extends Thread{
	private ConversorTextoMusica conversor;
	private Player player = new Player();

	public ControleDeMusica(EntradaDeTexto entradaTexto) {
		conversor = new ConversorTextoMusica(entradaTexto);
	}

	public void tocarMusica() {
		if(player.isPlaying() == false) {
			if(player.isPaused()) {
				System.out.println("resumindo");
				player.resume();
			}
			else {
				String textoConvertidoEmSequencia = conversor.converterTextoParaSequencia();
				System.out.println(textoConvertidoEmSequencia);
				player.play(textoConvertidoEmSequencia);
			}
		}
	}

	public void pararMusica() {
		if(player.isFinished() == false){
			player.stop();
		}
	}

	public void pausarMusica() {
		if(player.isPlaying()) {
			player.pause();
		}
	}

	public void run() {
			tocarMusica();
	}
}
