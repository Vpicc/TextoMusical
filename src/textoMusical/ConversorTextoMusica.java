package textoMusical;

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
		Musica musica = new Musica();
		
		String sequencia = "";
		String texto = entradaTexto.getCaixaDeTexto();

		
		sequencia += traduzirInstrumento(musica.getInstrumento())+ " " + traduzirVolume(musica.getVolume());
		
		for(int i = 0; i < texto.length(); i++) {
			if(i == 0) {
				sequencia += " " + converterCaractere(Character.toString(texto.charAt(i)),"", musica) + " ";
			} else {
				sequencia += converterCaractere(Character.toString(texto.charAt(i)),Character.toString(texto.charAt(i-1)), musica) + " ";
			}		
		}
		
		
		return sequencia;
	}
	
	private String traduzirInstrumento(int instrumento) {
		return "I"+Integer.toString(instrumento);
	}
	
	private String traduzirVolume(int volume) {
		return "X[Volume]="+Integer.toString(volume);
	}
	
	private String converterCaractere(String caractere,String caractereAnterior, Musica musica) {
		switch(caractere) {
			case "A":
			case "B":
			case "C":
			case "D":
			case "E":
			case "F":
			case "G":
				return (caractere+traduzirOitava(musica.getOitava()));
		}
		switch(caractere.toLowerCase()) {
			case "!":
				musica.trocarInstrumento(Instrumento.HARPSICHORD);
				return traduzirInstrumento(musica.getInstrumento());
			case "o":
			case "i":
			case "u":
				musica.aumentaVolume(0.1);
				return traduzirVolume(musica.getVolume());
			case "a":
			case "b":
			case "c":
			case "d":
			case "e":
			case "f":
			case "g":
			case "h":
			case "j":
			case "k":
			case "l":
			case "m":
			case "n":
			case "p":
			case "q":
			case "r":
			case "s":
			case "t":
			case "v":
			case "w":
			case "x":
			case "y":
			case "z":
				if(notaValida(caractereAnterior)) {
					return (caractereAnterior+traduzirOitava(musica.getOitava()));
				} else {
					return "R";
				}
			case "0":
			case "2":
			case "4":
			case "6":
			case "8":
			case "1":
			case "3":
			case "5":
			case "7":
			case "9":
				musica.trocarInstrumento(Integer.parseInt(caractere));
				return traduzirInstrumento(musica.getInstrumento());
			case "?":
			case ".":
				if(musica.getInstrumento() < musica.getMaxInstrumento()) {
					musica.aumentaOitava();
				} else {
					musica.setOitavaDefault();
				}
				break;
			case "\r":
				musica.trocarInstrumento(Instrumento.TUBULAR_BELLS);
				return this.traduzirInstrumento(musica.getInstrumento());
			case ";":
				musica.trocarInstrumento(Instrumento.PAN_FLUTE);
				return this.traduzirInstrumento(musica.getInstrumento());
			case ",":
				musica.trocarInstrumento(Instrumento.CHURCH_ORGAN);
				return this.traduzirInstrumento(musica.getInstrumento());
			case " ":
				musica.aumentaVolume(1);
				return traduzirVolume(musica.getVolume());
			default:
				if(notaValida(caractereAnterior)) {
					return (caractereAnterior+traduzirOitava(musica.getOitava()));
				} else {
					return "R";
				}
		}
		
		return "";
		
	}
	
	private String traduzirOitava(int oitava) {
		return Integer.toString(oitava);
	}
	
	/* Deprecated
	private String traduzirBpm(int bpm) {
		return "T"+Integer.toString(bpm);
	}
	*/
	
	private boolean notaValida(String caractere) {
		switch(caractere) {
			case "A":
			case "B":
			case "C":
			case "D":
			case "E":
			case "F":
			case "G":
				return true;
		}
		
		return false;
	}
	
	

}
