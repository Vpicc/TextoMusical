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
				System.out.println("NAO");
				String textoConvertidoEmSequencia = conversor.converterTextoParaSequencia();

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


	public void voltarMusica() { //IMPLEMENTEI TODO ELE NA WINDOW.JAVA
		this.pararMusica();
		this.tocarMusica();
	}
	public void run() {
		if(player.isPaused()) {
			System.out.println("resumindo THREAD");
			player.resume();
		}
		else {
			System.out.println("NAO thread");
			String textoConvertidoEmSequencia = conversor.converterTextoParaSequencia();

			player.play(textoConvertidoEmSequencia);
		}
	}
}
