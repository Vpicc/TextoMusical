package gui;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class BarraDeMenu implements ComponenteGUI {
	JFrame telaPrincipal;
	JMenuBar barraDeMenu = new JMenuBar();
	CaixaDeTexto caixaDeTexto;
	
	public BarraDeMenu(JFrame tela, CaixaDeTexto caixaTexto) {
		telaPrincipal = tela;
		caixaDeTexto = caixaTexto;
	}
	
	public void inicializar() {
		telaPrincipal.setJMenuBar(barraDeMenu);
		
		MenuArquivo menuArquivo = new MenuArquivo(caixaDeTexto, telaPrincipal);
		menuArquivo.inicializar();
		
		barraDeMenu.add(menuArquivo.getJMenu());
		
		MenuAjuda menuAjuda = new MenuAjuda();
		menuAjuda.inicializar();
		
		barraDeMenu.add(menuAjuda.getJMenu());
		
		
	}
	
}
