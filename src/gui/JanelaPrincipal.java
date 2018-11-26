package gui;

import javax.swing.JFrame;

public class JanelaPrincipal{

	private JFrame telaPrincipal;

	public void inicializar() {
		telaPrincipal = Janela.criaJanela("Texto Musical",Janela.Tipo.PRINCIPAL);
		CaixaDeTexto caixaDeTexto = new CaixaDeTexto(telaPrincipal);
		Botoes botoes = new Botoes(telaPrincipal, caixaDeTexto);
		
		botoes.inicializar();
		caixaDeTexto.inicializar();
		
		Menu menu = new Menu(telaPrincipal,caixaDeTexto);
		menu.inicializar();
		
		
	}
}
