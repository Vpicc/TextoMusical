package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
		//Cria um Jpanel contendo todos os botoes
		JPanel painelDeBotoes = new JPanel();
		painelDeBotoes.setLayout(new FlowLayout());
		
		botaoReproduzir(painelDeBotoes);
		botaoPausar(painelDeBotoes);
		botaoParar(painelDeBotoes);
		botaoVoltar(painelDeBotoes);
		
		telaPrincipal.getContentPane().add(BorderLayout.SOUTH,painelDeBotoes);

		
	}
	
	private void botaoReproduzir(JPanel painelDeBotoes) {
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
		painelDeBotoes.add(Reproduzir);
	}
	
	private void botaoParar(JPanel painelDeBotoes) {
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
		painelDeBotoes.add(Parar);

	}
	
	private void botaoPausar(JPanel painelDeBotoes) {
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
		painelDeBotoes.add(Pausar);
	}
	
	private void botaoVoltar(JPanel painelDeBotoes) {
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
		painelDeBotoes.add(Voltar);
	}
	
	private void geraThreadDeControle(){
		threadDeControle = new ControleDeMusica(caixaDeTexto.getEntradaDeTexto());
	}

}
