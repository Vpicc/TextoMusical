package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class JanelaSobre extends Janela{
	
	public void inicializar() {
		JFrame telaSobre = criaJanela("Sobre", 100, 100, 260, 160,Janela.Tipo.ADICIONAL);
		JLabel labelSobre = new JLabel();
		labelSobre.setText("<html>Autores:<br>Enrico Ossanai<br>Victor Piccoli<br>Samuel Rudnicki</html>");
		labelSobre.setBounds(10,0,100,100);
		telaSobre.getContentPane().add(labelSobre);
	}
	
}
