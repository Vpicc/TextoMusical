package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public abstract class Janela implements ComponenteGUI {
	
	protected enum Tipo {
		PRINCIPAL,
		ADICIONAL
	}
	
	public abstract void inicializar();
	
	private int escolheTipo(Tipo opcao) {
		switch(opcao) {
			case PRINCIPAL:
				return JFrame.EXIT_ON_CLOSE;
			case ADICIONAL:
				return JFrame.DISPOSE_ON_CLOSE;
		}
		return -1;
	}
	
	protected JFrame criaJanela(String nome, Tipo opcao) {
		JFrame novaTela = new JFrame();
		novaTela.setTitle(nome);
		novaTela.setBounds(100, 100, 450, 321);
		novaTela.setDefaultCloseOperation(escolheTipo(opcao));
		novaTela.getContentPane().setLayout(new BorderLayout());
		novaTela.setVisible(true);
		return novaTela;
	}
	
	protected JFrame criaJanela(String nome, int x, int y, int largura, int altura, Tipo opcao) {
		JFrame novaTela = new JFrame();
		novaTela.setTitle(nome);
		novaTela.setBounds(x, y, largura, altura);
		novaTela.setDefaultCloseOperation(escolheTipo(opcao));
		novaTela.getContentPane().setLayout(null);
		novaTela.setVisible(true);
		return novaTela;
	}
}
