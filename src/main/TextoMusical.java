package main;
import java.awt.EventQueue;

import gui.Janela;

public class TextoMusical {
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela janela = new Janela();
					janela.inicializar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
