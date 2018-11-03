
public class ConversorTextoMusica {
	private EntradaDeTexto entradaTexto;
	
	
	public ConversorTextoMusica(EntradaDeTexto entradaTexto) {
		this.entradaTexto = entradaTexto;
	}
	
	public EntradaDeTexto getEntradaTexto() {
		return entradaTexto;
	}
	
	public void setEntradaTexto(EntradaDeTexto entradaTexto) {
		this.entradaTexto = entradaTexto;
	}
	
	public String converterTextoParaSequencia() {
		// Faz a tradução do texto para uma String que Jfugue entende
		int oitava = Default.oitava;
		int instrumento = Default.instrumento;
		int bpm = Default.bpm;
		int volume = Default.volume;
		
		String sequencia = "";
		String texto = entradaTexto.getCaixaDeTexto();
		
		sequencia += escolherInstrumento(instrumento);
		
		for(int i = 0; i < texto.length(); i++) {
			switch(texto.charAt(i)) {
				
			}
			
		}
		
		
		return sequencia;
	}
	
	private String escolherInstrumento(int opcao) {
		switch(opcao) {
		case 0:
			return "I[Piano]";
		case 1:
			return "I[Flute]";
		case 2:
			return "I[Violin]";
		case 3:
			return "I[Guitar]";
		default:
			return "I[Piano]";
		}
	}
	

}
