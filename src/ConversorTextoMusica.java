
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
		texto = texto.toLowerCase();
		
		sequencia += escolherInstrumento(musica.getInstrumento());
		
		for(int i = 0; i < texto.length(); i++) {
			sequencia += converterCaractere(texto.charAt(i), musica) + " ";
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
	
	private String traduzirVolume(int volume) {
		return "X[Volume]="+Integer.toString(volume);
	}
	
	private String converterCaractere(char caractere, Musica musica) {
		switch(caractere) {
			case '!':
				musica.dobraVolume();
				return traduzirVolume(musica.getVolume());
			case 'o':
			case 'i':
			case 'u':
				musica.metadeVolume();
				return traduzirVolume(musica.getVolume());
			case 'a':
			case 'b':
			case 'c':
			case 'd':
			case 'f':
			case 'g':
				return (Character.toString(caractere)+traduzirOitava(musica.getOitava()));
			case 'h':
			case 'j':
			case 'k':
			case 'l':
			case 'm':
			case 'n':
			case 'p':
			case 'q':
			case 'r':
			case 's':
			case 't':
			case 'v':
			case 'w':
			case 'x':
			case 'y':
			case 'z':
				break;
			case '0':
			case '2':
			case '4':
			case '6':
			case '8':
				musica.aumentaOitava();
				break;
			case '1':
			case '3':
			case '5':
			case '7':
			case '9':
				musica.diminuiOitava();
				break;
			
			case '?':
			case '.':
				musica.setOitavaDefault();
				break;
			case '\r':
				musica.trocarInstrumento();
				return this.escolherInstrumento(musica.getInstrumento());
			case ';':
				musica.aumentaRitmo();
				break;
			case ',':
				musica.diminuiRitmo();
				break;
			default:
				return "";
		}
		
		return "";
		
	}
	
	private String traduzirOitava(int oitava) {
		return Integer.toString(oitava);
	}
	
	private String traduzirBpm(int bpm) {
		return "T"+Integer.toString(bpm);
	}
	
	

}
