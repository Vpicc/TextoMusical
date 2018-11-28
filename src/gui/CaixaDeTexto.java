package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import textoMusical.EntradaDeTexto;

public class CaixaDeTexto implements ComponenteGUI{
	private EntradaDeTexto entradaDeTexto = new EntradaDeTexto("");
	private JFrame telaPrincipal;
	JTextPane caixaDeTexto;
	JScrollPane caixaDeTextoComScroll;
	
	public CaixaDeTexto(JFrame tela) {
		telaPrincipal = tela;
	}
	
	public EntradaDeTexto getEntradaDeTexto() {
		return entradaDeTexto;
	}
	
	public String getTexto() {
		return entradaDeTexto.getCaixaDeTexto();
	}
	
	public void setTexto(String entradaTexto) {
		entradaDeTexto.setCaixaDeTexto(entradaTexto);
		caixaDeTexto.setText(entradaTexto);
	}
	
	
	public void inicializar() {
		caixaDeTexto = new JTextPane();
		caixaDeTextoComScroll = new JScrollPane(caixaDeTexto);
		caixaDeTextoComScroll.setToolTipText("Digite o texto...");
		caixaDeTexto.getDocument().addDocumentListener(acaoTexto());
		telaPrincipal.getContentPane().add(BorderLayout.CENTER,caixaDeTextoComScroll);
	}
	
	private DocumentListener acaoTexto() {
		return new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent e) {
				entradaDeTexto.setCaixaDeTexto(caixaDeTexto.getText());
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				entradaDeTexto.setCaixaDeTexto(caixaDeTexto.getText());	
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				entradaDeTexto.setCaixaDeTexto(caixaDeTexto.getText());
			}
			
		};
	}

}
