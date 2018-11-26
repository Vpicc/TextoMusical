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

	public void inicializar() {
		telaPrincipal = new JFrame();
		telaPrincipal.setTitle("Texto Musical");
		telaPrincipal.setBounds(100, 100, 450, 321);
		telaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaPrincipal.getContentPane().setLayout(null);
		CaixaDeTexto caixaDeTexto = new CaixaDeTexto(telaPrincipal);
		Botoes botoes = new Botoes(telaPrincipal, caixaDeTexto);
		
		botoes.inicializar();
		caixaDeTexto.inicializar();
		
		MenuArquivo menuArquivo = new MenuArquivo(telaPrincipal, caixaDeTexto);
		menuArquivo.inicializar();

		telaPrincipal.setVisible(true);
	}
}
