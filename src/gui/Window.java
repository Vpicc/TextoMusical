package gui;
import textoMusical.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class Window{

	private JFrame TelaPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.TelaPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private ControleDeMusica threadDeControle = new ControleDeMusica(null);

	private void initialize() {
		TelaPrincipal = new JFrame();
		TelaPrincipal.setTitle("Conversor Texto-música");
		TelaPrincipal.setBounds(100, 100, 450, 321);
		TelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TelaPrincipal.getContentPane().setLayout(null);

		JTextPane caixaDeTexto = new JTextPane();
		caixaDeTexto.setToolTipText("Digite o texto...");
		caixaDeTexto.setBounds(55, 12, 333, 184);
		TelaPrincipal.getContentPane().add(caixaDeTexto);

		JButton Reproduzir = new JButton("");
		Reproduzir.setToolTipText("PLAY");
		Reproduzir.setIcon(new ImageIcon(Window.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlay.png")));
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
		TelaPrincipal.getContentPane().add(Reproduzir);

		JButton Parar = new JButton("STOP");
		Parar.setToolTipText("STOP");
		Parar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				threadDeControle.pararMusica();
			}
		});
		Parar.setBounds(250, 208, 117, 25);
		TelaPrincipal.getContentPane().add(Parar);

		JButton Pausar = new JButton("");
		Pausar.setToolTipText("PAUSE");
		Pausar.setIcon(new ImageIcon(Window.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPause.png")));
		Pausar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(threadDeControle.isAlive())
					threadDeControle.pausarMusica();
				return;
			}
		});
		Pausar.setBounds(65, 233, 117, 25);
		TelaPrincipal.getContentPane().add(Pausar);

		JButton Voltar = new JButton("REWIND");
		Voltar.setToolTipText("REWIND");
		Voltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			threadDeControle.voltarMusica();
			}
		});
		Voltar.setBounds(250, 233, 117, 25);
		TelaPrincipal.getContentPane().add(Voltar);

		JMenuBar menuBar = new JMenuBar();
		TelaPrincipal.setJMenuBar(menuBar);

		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);

		JMenuItem Abrir = new JMenuItem("Abrir...");
		Abrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fs = new JFileChooser();
				fs.setDialogTitle("Abrir arquivo");
				fs.setFileFilter(new FiltroTipoDeArquivo(".txt", "Arquivo .txt"));
				int resultado = fs.showOpenDialog(null);
				if (resultado == JFileChooser.APPROVE_OPTION) {
					try {
						File arq = fs.getSelectedFile();
						BufferedReader br = new BufferedReader(new FileReader(arq.getPath()));
						String buffer = "";
						String linha = "";
						while((linha=br.readLine()) != null) {
							buffer += linha;
						}
						caixaDeTexto.setText(buffer);
						if (br != null) {
							br.close();
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}
				}


			}
		});
		mnArquivo.add(Abrir);

		JMenuItem SalvarComo = new JMenuItem("Salvar como...");
		SalvarComo.addActionListener(new ActionListener() {
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
		});
		mnArquivo.add(SalvarComo);

		JMenuItem Sair = new JMenuItem("Sair");
		Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal.dispatchEvent(new WindowEvent(
						TelaPrincipal, WindowEvent.WINDOW_CLOSING));
			}
		});

		JMenuItem SalvarMidi = new JMenuItem("Salvar MIDI como...");
		SalvarMidi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fs = new JFileChooser();
				fs.setDialogTitle("Salvar MIDI");
				fs.setFileFilter(new FiltroTipoDeArquivo(".midi", "Arquivo .midi"));
				int resultado = fs.showSaveDialog(null);
				if (resultado == JFileChooser.APPROVE_OPTION) {
					File arq = fs.getSelectedFile();
					try {
						threadDeControle.salvarMIDI(arq);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}

				}
			}
		});
		mnArquivo.add(SalvarMidi);
		mnArquivo.add(Sair);
	}
	public void geraSequenciaMusical(String texto){
		//System.out.println(texto);
		EntradaDeTexto a = new EntradaDeTexto(texto);
		if(threadDeControle.isAlive())
			return;
		else {
			threadDeControle = new ControleDeMusica(a);
		}
	}
}
