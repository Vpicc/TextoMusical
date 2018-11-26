package gui;
import textoMusical.*;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
public class Janela{

	private JFrame telaPrincipal;
	private EntradaDeTexto entradaDeTexto = new EntradaDeTexto("");
	private ControleDeMusica threadDeControle = new ControleDeMusica(null);

	public void inicializar() {
		telaPrincipal = new JFrame();
		telaPrincipal.setTitle("Texto Musical");
		telaPrincipal.setBounds(100, 100, 450, 321);
		telaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaPrincipal.getContentPane().setLayout(null);

		JTextPane caixaDeTexto = new JTextPane();
		JScrollPane caixaDeTextoComScroll = new JScrollPane(caixaDeTexto);
		caixaDeTextoComScroll.setToolTipText("Digite o texto...");
		caixaDeTextoComScroll.setBounds(55, 12, 333, 184);
		telaPrincipal.getContentPane().add(caixaDeTextoComScroll);
		
		MenuArquivo menuArquivo = new MenuArquivo(telaPrincipal, entradaDeTexto, caixaDeTexto);
		menuArquivo.inicializar();
		
		

		JButton Reproduzir = new JButton("");
		Reproduzir.setToolTipText("PLAY");
		Reproduzir.setIcon(new ImageIcon(Janela.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlay.png")));
		Reproduzir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String texto = caixaDeTexto.getText();
				geraSequenciaMusical(texto);
				//Thread que chama a funcao run() na classe ControleDeMusica
				if(threadDeControle.isAlive()) {
					threadDeControle.tocarMusica();		
				}
				else {
					threadDeControle.start();				
				}

			}
		});
		Reproduzir.setBounds(65, 208, 117, 25);
		telaPrincipal.getContentPane().add(Reproduzir);

		JButton Parar = new JButton("STOP");
		Parar.setToolTipText("STOP");
		Parar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				threadDeControle.pararMusica();
			}
		});
		Parar.setBounds(250, 208, 117, 25);
		telaPrincipal.getContentPane().add(Parar);

		JButton Pausar = new JButton("");
		Pausar.setToolTipText("PAUSE");
		Pausar.setIcon(new ImageIcon(Janela.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPause.png")));
		Pausar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(threadDeControle.isAlive())
					threadDeControle.pausarMusica();
				return;
			}
		});
		Pausar.setBounds(65, 233, 117, 25);
		telaPrincipal.getContentPane().add(Pausar);

		JButton Voltar = new JButton("REWIND");
		Voltar.setToolTipText("REWIND");
		Voltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			threadDeControle.voltarMusica();
			}
		});
		Voltar.setBounds(250, 233, 117, 25);
		telaPrincipal.getContentPane().add(Voltar);

		
		telaPrincipal.setVisible(true);
	}
	public void geraSequenciaMusical(String texto){
		//System.out.println(texto);
		entradaDeTexto.setCaixaDeTexto(texto);
		if(threadDeControle.isAlive())
			return;
		else {
			threadDeControle = new ControleDeMusica(entradaDeTexto);
		}
	}
}
