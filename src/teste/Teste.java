package teste;
import textoMusical.*;
import org.jfugue.*;

public class Teste {

	public static void main(String[] args) {
		
		EntradaDeTexto a = new EntradaDeTexto("Estou testando isso, pf funcione AA A A A A A A A.");
				
		ControleDeMusica c = new ControleDeMusica(a);
		
		c.tocarMusica();
		
	}
}
