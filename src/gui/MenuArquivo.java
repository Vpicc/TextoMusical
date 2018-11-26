package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import textoMusical.Arquivo;
import textoMusical.EntradaDeTexto;

public class MenuArquivo {
	private JFrame telaPrincipal;
	private Arquivo controleDeArquivo;
	JMenu mnArquivo = new JMenu("Arquivo");
	JTextPane caixaDeTexto;
	
	public MenuArquivo (JFrame tela, EntradaDeTexto entradaDeTexto, JTextPane caixaTexto) {
		telaPrincipal = tela;
		controleDeArquivo = new Arquivo(entradaDeTexto);
		caixaDeTexto = caixaTexto;
	}
	
	public void inicializar() {
		JMenuBar menuBar = new JMenuBar();
		telaPrincipal.setJMenuBar(menuBar);
		
		menuBar.add(mnArquivo);
		
		adicionaOpcaoAbrir();
		
		adicionaOpcaoSalvarComo();

		adicionaOpcaoSair();
		
		adicionaOpcaoSalvarMidi();
		
		

	}
	
	private void adicionaOpcaoAbrir() {
		JMenuItem Abrir = new JMenuItem("Abrir...");
		Abrir.addActionListener(acaoAbrir());
		mnArquivo.add(Abrir);
	}
	
	private ActionListener acaoAbrir() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fs = new JFileChooser();
				fs.setDialogTitle("Abrir arquivo");
				fs.setFileFilter(new FiltroTipoDeArquivo(".txt", "Arquivo .txt"));
				int resultado = fs.showOpenDialog(null);
				if (resultado == JFileChooser.APPROVE_OPTION) {
					File arq = fs.getSelectedFile();
					controleDeArquivo.abrir(arq);
					caixaDeTexto.setText(controleDeArquivo.getEntradaTexto().getCaixaDeTexto());
				}
			}
		};
	}
	
	private void adicionaOpcaoSalvarComo() {
		JMenuItem SalvarComo = new JMenuItem("Salvar como...");
		SalvarComo.addActionListener(acaoSalvarComo());
		mnArquivo.add(SalvarComo);
	}
	
	private ActionListener acaoSalvarComo() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fs = new JFileChooser();
				fs.setDialogTitle("Salvar arquivo");
				fs.setFileFilter(new FiltroTipoDeArquivo(".txt", "Arquivo .txt"));
				int resultado = fs.showSaveDialog(null);
				if (resultado == JFileChooser.APPROVE_OPTION) {
					String conteudo = caixaDeTexto.getText();
					File arq = fs.getSelectedFile();
					try {
						FileWriter fw = new FileWriter(arq.getPath()+".txt");
						fw.write(conteudo);
						fw.flush();
						fw.close();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}

				}
			}
		};
	}
	
	private void adicionaOpcaoSair() {
		JMenuItem Sair = new JMenuItem("Sair");
		Sair.addActionListener(acaoSair());
		mnArquivo.add(Sair);
	}
	
	private ActionListener acaoSair() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaPrincipal.dispatchEvent(new WindowEvent(
						telaPrincipal, WindowEvent.WINDOW_CLOSING));
			}
		};
	}
	
	private void adicionaOpcaoSalvarMidi() {
		JMenuItem SalvarMidi = new JMenuItem("Salvar MIDI como...");
		SalvarMidi.addActionListener(acaoSalvarMidi());
		mnArquivo.add(SalvarMidi);
	}
	
	private ActionListener acaoSalvarMidi() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fs = new JFileChooser();
				fs.setDialogTitle("Salvar MIDI");
				fs.setFileFilter(new FiltroTipoDeArquivo(".midi", "Arquivo .midi"));
				int resultado = fs.showSaveDialog(null);
				if (resultado == JFileChooser.APPROVE_OPTION) {
					File arq = fs.getSelectedFile();
					try {
						controleDeArquivo.salvarMIDI(arq);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}

				}
			}
		};
	}
	
}
