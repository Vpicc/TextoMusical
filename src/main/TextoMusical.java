package main;
import java.awt.EventQueue;

import gui.JanelaPrincipal;

public class TextoMusical {
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal janela = new JanelaPrincipal();
					janela.inicializar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
