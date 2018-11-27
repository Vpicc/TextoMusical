package gui;

import javax.swing.JFrame;

public class JanelaPrincipal extends Janela{

	private JFrame telaPrincipal;

	public void inicializar() {
		telaPrincipal = criaJanela("Texto Musical",Tipo.PRINCIPAL);
		CaixaDeTexto caixaDeTexto = new CaixaDeTexto(telaPrincipal);
		Botoes botoes = new Botoes(telaPrincipal, caixaDeTexto);
		
		botoes.inicializar();
		caixaDeTexto.inicializar();
		
		BarraDeMenu menu = new BarraDeMenu(telaPrincipal,caixaDeTexto);
		menu.inicializar();
		
		
	}
}
