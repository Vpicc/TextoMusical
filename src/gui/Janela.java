package gui;

import javax.swing.JFrame;

public class Janela {
	
	public static enum Tipo {
		PRINCIPAL,
		ADICIONAL
	}
	
	private static int escolheTipo(Tipo opcao) {
		switch(opcao) {
			case PRINCIPAL:
				return JFrame.EXIT_ON_CLOSE;
			case ADICIONAL:
				return JFrame.DISPOSE_ON_CLOSE;
		}
		return -1;
	}
	
	public static JFrame criaJanela(String nome, Tipo opcao) {
		JFrame novaTela = new JFrame();
		novaTela.setTitle(nome);
		novaTela.setBounds(100, 100, 450, 321);
		novaTela.setDefaultCloseOperation(escolheTipo(opcao));
		novaTela.getContentPane().setLayout(null);
		novaTela.setVisible(true);
		return novaTela;
	}
	
	public static JFrame criaJanela(String nome, int x, int y, int largura, int altura, Tipo opcao) {
		JFrame novaTela = new JFrame();
		novaTela.setTitle(nome);
		novaTela.setBounds(x, y, largura, altura);
		novaTela.setDefaultCloseOperation(escolheTipo(opcao));
		novaTela.getContentPane().setLayout(null);
		novaTela.setVisible(true);
		return novaTela;
	}
}
