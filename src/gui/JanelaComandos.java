package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class JanelaComandos extends Janela{
	
	public void inicializar() {
		JFrame telaComandos = criaJanela("Sobre", 100, 100, 950, 535,Janela.Tipo.ADICIONAL);
		telaComandos.setLayout(new BorderLayout());
		JLabel labelComandos = new JLabel();
		labelComandos.setText(textoComandos());
		JScrollPane labelComandosComScroll = new JScrollPane(labelComandos);
		telaComandos.getContentPane().add(BorderLayout.CENTER,labelComandosComScroll);
	}
	
	private String textoComandos() {
		return "<html><meta http-equiv='content-type' content='text/html;charset=utf-8'><table border=\"1\"><tr><th>Texto</th><th>A��o</th></tr>"
				+ "<tr><td>A (mai�sculo)</td><td>Nota L�</td></tr>"
				+ "<tr><td>B (mai�sculo)</td><td>Nota Si</td></tr>"
				+ "<tr><td>C (mai�sculo)</td><td>Nota D�</td></tr>"
				+ "<tr><td>D (mai�sculo)</td><td>Nota R�</td></tr>"
				+ "<tr><td>E (mai�sculo)</td><td>Nota Mi</td></tr>"
				+ "<tr><td>F (mai�sculo)</td><td>Nota F�</td></tr>"
				+ "<tr><td>G (mai�sculo)</td><td>Nota Sol</td></tr>"
				+ "<tr><td>Espa�o</td><td>Aumenta o volume para o DOBRO do volume</td></tr>"
				+ "<tr><td>!</td><td>Troca instrumento para Harpsichord</td></tr>"
				+ "<tr><td>O ou o,I ou i,U ou u</td><td>Aumenta volume em 10%</td></tr>"
				+ "<tr><td>D�gito par ou impar</td><td>Troca instrumento para o General MIDI cujo numero � igual ao valor do instrumento ATUAL + valor do d�gito</td></tr>"
				+ "<tr><td>? e .</td><td>Aumenta UMA oitava; Se n�o puder aumentar, volta para a default</td></tr>"
				+ "<tr><td>NL (Nova Linha)</td><td>Troca instrumento para Tubular Bells</td></tr>"
				+ "<tr><td>;</td><td>Troca Instrumento para Pan Flute</td></tr>"
				+ "<tr><td>,</td><td>Troca Instrumento para Church Organ</td></tr>"
				+ "<tr><td>Outros caracteres</td><td>Se caractere anterior era NOTA(A a G) repete a nota; Caso contr�rio sil�ncio</td></tr>"
				+ "</table></html>";
	}
}
