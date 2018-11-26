package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class MenuAjuda {
	JFrame telaPrincipal;
	JMenu mnAjuda = new JMenu("Ajuda");
	
	
	public void inicializar() {
		adicionaOpcaoSobre();
		adicionaOpcaoComandos();
	}
	
	public JMenu getJMenu() {
		return mnAjuda;
	}
	
	private void adicionaOpcaoSobre() {
		JMenuItem sobre = new JMenuItem("Sobre");
		sobre.addActionListener(acaoSobre());
		mnAjuda.add(sobre);
	}
	
	private ActionListener acaoSobre() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame telaSobre = Janela.criaJanela("Sobre", 100, 100, 260, 160,Janela.Tipo.ADICIONAL);
				JLabel labelSobre = new JLabel();
				labelSobre.setText("<html>Autores:<br>Enrico Ossanai<br>Victor Piccoli<br>Samuel Rudnicki</html>");
				labelSobre.setBounds(10,0,100,100);
				telaSobre.getContentPane().add(labelSobre);
			}
		};
	}
	
	private void adicionaOpcaoComandos() {
		JMenuItem comandos = new JMenuItem("Comandos");
		comandos.addActionListener(acaoComandos());
		mnAjuda.add(comandos);
	}
	
	private ActionListener acaoComandos() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame telaSobre = Janela.criaJanela("Sobre", 100, 100, 260, 160,Janela.Tipo.ADICIONAL);
				JLabel labelSobre = new JLabel();
				labelSobre.setText("<html>COMANDOS:</html>");
				labelSobre.setBounds(10,0,100,100);
				telaSobre.getContentPane().add(labelSobre);
			}
		};
	}
	

	
	
}
