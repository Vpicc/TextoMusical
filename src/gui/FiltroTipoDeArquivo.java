package gui;

import java.io.File;
import javax.swing.filechooser.*;

public class FiltroTipoDeArquivo extends FileFilter{

	private final String extensao;
	private final String descricao;
	
	public FiltroTipoDeArquivo(String extensao, String descricao) {
		this.extensao= extensao;
		this.descricao = descricao;
	}

	@Override
	public boolean accept(File arq) {
		if (arq.isDirectory()) {
		return true;
		}
		return arq.getName().endsWith(extensao);
	}

	@Override
	public String getDescription() {
		return descricao + String.format(" (*%s)", extensao);
	}
}
