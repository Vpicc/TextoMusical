package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class JanelaComandos extends Janela{
	
	public void inicializar() {
		JFrame telaComandos = criaJanela("Sobre", 100, 100, 720, 535,Janela.Tipo.ADICIONAL);
		JLabel labelComandos = new JLabel();
		labelComandos.setText(textoComandos());
		labelComandos.setBounds(0,-100,700,700);
		telaComandos.getContentPane().add(labelComandos);
	}
	
	private String textoComandos() {
		return "<html><table border=\"1\"><tr><th>Texto</th><th>A��o</th></tr>"
				+ "<tr><td>A (mai�sculo)</td><td>Nota L�</td></tr>"
				+ "<tr><td>B (mai�sculo)</td><td>Nota Si</td></tr>"
				+ "<tr><td>C (mai�sculo)</td><td>Nota D�</td></tr>"
				+ "<tr><td>D (mai�sculo)</td><td>Nota R�</td></tr>"
				+ "<tr><td>E (mai�sculo)</td><td>Nota Mi</td></tr>"
				+ "<tr><td>F (mai�sculo)</td><td>Nota F�</td></tr>"
				+ "<tr><td>G (mai�sculo)</td><td>Nota Sol</td></tr>"
				+ "<tr><td>Espa�o</td><td>Aumenta o volume para o DOBRO do volume</td></tr>"
				+ "<tr><td>!</td><td>Troca instrumento para Harpsichord</td></tr>"
				+ "<tr><td>Outra letra vogal</td><td>Aumenta volume em 10%</td></tr>"
				+ "<tr><td>D�gito par ou impar</td><td>Troca instrumento para o General MIDI cujo Numero � igual ao valor do instrumento ATUAL + valor do d�gito</td></tr>"
				+ "<tr><td>? e .</td><td>Aumenta UMA oitava; Se n�o puder aumentar, volta para a default</td></tr>"
				+ "<tr><td>NL (Nova Linha)</td><td>Troca instrumento para Tubular Bells</td></tr>"
				+ "<tr><td>;</td><td>Troca Instrumento para Pan Flute</td></tr>"
				+ "<tr><td>,</td><td>Troca Instrumento para Church Organ</td></tr>"
				+ "<tr><td>Outros caracteres</td><td>Se caractere anterior era NOTA(A a G) repete a nota; Caso contr�rio sil�ncio</td></tr>"
				+ "</table></html>";
	}
}
