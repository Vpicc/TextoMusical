package gui;


import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class JanelaSobre extends Janela{
	
	public void inicializar() {
		JFrame telaSobre = criaJanela("Sobre", 100, 100, 260, 160,Janela.Tipo.ADICIONAL);
		telaSobre.setLayout(new BorderLayout());
		JLabel labelSobre = new JLabel();
		labelSobre.setText("<html>Autores:<br>Enrico Ossanai<br>Victor Piccoli<br>Samuel Rudnicki</html>");
		JScrollPane labelSobreComScroll = new JScrollPane(labelSobre);
		telaSobre.getContentPane().add(BorderLayout.CENTER,labelSobreComScroll);
	}
	
}
