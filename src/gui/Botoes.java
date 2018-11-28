package gui;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import textoMusical.ControleDeMusica;

public class Botoes implements ComponenteGUI {
	private JFrame telaPrincipal;
	private ControleDeMusica threadDeControle;
	private CaixaDeTexto caixaDeTexto;
	private final int DIMENSAO_ICONE = 20;
	
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
		try{
		Image img = ImageIO.read(getClass().getResource("img/play.png"));
		Reproduzir.setIcon(new ImageIcon(img.getScaledInstance(DIMENSAO_ICONE, DIMENSAO_ICONE, Image.SCALE_SMOOTH)));
		} catch (Exception ex) {
			System.out.println(ex);
		}
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
		JButton Parar = new JButton("");
		Parar.setToolTipText("STOP");
		try{
		Image img = ImageIO.read(getClass().getResource("img/stop.png"));
		Parar.setIcon(new ImageIcon(img.getScaledInstance(DIMENSAO_ICONE, DIMENSAO_ICONE, Image.SCALE_SMOOTH)));
		} catch (Exception ex) {
			System.out.println(ex);
		}
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
		try{
		Image img = ImageIO.read(getClass().getResource("img/pause.png"));
		Pausar.setIcon(new ImageIcon(img.getScaledInstance(DIMENSAO_ICONE, DIMENSAO_ICONE, Image.SCALE_SMOOTH)));
		} catch (Exception ex) {
			System.out.println(ex);
		}
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
		JButton Voltar = new JButton("");
		Voltar.setToolTipText("REWIND");
		try{
		Image img = ImageIO.read(getClass().getResource("img/rewind.png"));
		Voltar.setIcon(new ImageIcon(img.getScaledInstance(DIMENSAO_ICONE, DIMENSAO_ICONE, Image.SCALE_SMOOTH)));
		} catch (Exception ex) {
			System.out.println(ex);
		}
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
