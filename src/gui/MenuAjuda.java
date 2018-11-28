package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;



public class MenuAjuda implements ComponenteGUI {
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
				JanelaSobre janelaSobre = new JanelaSobre();
				janelaSobre.inicializar();
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
				JanelaComandos janelaComandos = new JanelaComandos();
				janelaComandos.inicializar();
			}
		};
	}

		
	
}
