package gui;

import javax.swing.JFrame;

public class Janela{

	private JFrame telaPrincipal;

	public void inicializar() {
		telaPrincipal = new JFrame();
		telaPrincipal.setTitle("Texto Musical");
		telaPrincipal.setBounds(100, 100, 450, 321);
		telaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaPrincipal.getContentPane().setLayout(null);
		CaixaDeTexto caixaDeTexto = new CaixaDeTexto(telaPrincipal);
		Botoes botoes = new Botoes(telaPrincipal, caixaDeTexto);
		
		botoes.inicializar();
		caixaDeTexto.inicializar();
		
		MenuArquivo menuArquivo = new MenuArquivo(telaPrincipal, caixaDeTexto);
		menuArquivo.inicializar();

		telaPrincipal.setVisible(true);
	}
}
