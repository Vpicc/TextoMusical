package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import textoMusical.ControleDeMusica;

public class Botoes {
	private JFrame telaPrincipal;
	private ControleDeMusica threadDeControle;
	private CaixaDeTexto caixaDeTexto;
	
	public Botoes(JFrame tela, CaixaDeTexto caixaTexto) {
		telaPrincipal = tela;
		threadDeControle = new ControleDeMusica(caixaTexto.getEntradaDeTexto());
		caixaDeTexto = caixaTexto;
	}
	
	public void inicializar() {
		botaoReproduzir();
		botaoParar();
		botaoPausar();
		botaoVoltar();
		
	}
	
	private void botaoReproduzir() {
		JButton Reproduzir = new JButton("");
		Reproduzir.setToolTipText("PLAY");
		Reproduzir.setIcon(new ImageIcon(Janela.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlay.png")));
		Reproduzir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Thread que chama a funcao run() na classe ControleDeMusica
				if(threadDeControle.isAlive()) {
					threadDeControle.tocarMusica();		
				}
				else {
					geraThreadDeControle();
					threadDeControle.start();
				}

			}
		});
		Reproduzir.setBounds(65, 208, 117, 25);
		telaPrincipal.getContentPane().add(Reproduzir);
	}
	
	private void botaoParar() {
		JButton Parar = new JButton("STOP");
		Parar.setToolTipText("STOP");
		Parar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(threadDeControle.isAlive()) {
					threadDeControle.pararMusica();
				}
			}
		});
		Parar.setBounds(250, 208, 117, 25);
		telaPrincipal.getContentPane().add(Parar);

	}
	
	private void botaoPausar() {
		JButton Pausar = new JButton("");
		Pausar.setToolTipText("PAUSE");
		Pausar.setIcon(new ImageIcon(Janela.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPause.png")));
		Pausar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(threadDeControle.isAlive()) {
					threadDeControle.pausarMusica();
				}
			}
		});
		Pausar.setBounds(65, 233, 117, 25);
		telaPrincipal.getContentPane().add(Pausar);
	}
	
	private void botaoVoltar() {
		JButton Voltar = new JButton("REWIND");
		Voltar.setToolTipText("REWIND");
		Voltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (threadDeControle.isAlive()) {
					threadDeControle.pararMusica();
					geraThreadDeControle();
					threadDeControle.start();
				}

			}
		});
		Voltar.setBounds(250, 233, 117, 25);
		telaPrincipal.getContentPane().add(Voltar);
	}
	
	private void geraThreadDeControle(){
		threadDeControle = new ControleDeMusica(caixaDeTexto.getEntradaDeTexto());
	}

}
