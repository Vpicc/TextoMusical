package textoMusical;

public class Musica {
	private int oitava;
	private int instrumento;
	private int bpm;
	private int volume;
	private final int MAX_VOLUME = 16383;
	private final int MAX_BPM = 10000;
	private final int MAX_OITAVA = 9;
	private final int MAX_INSTRUMENTO = 127;
	private final int DEFAULT_OITAVA = 0;
	private final int DEFAULT_INSTRUMENTO = 0;
	private final int DEFAULT_BPM = 120;
	private final int DEFAULT_VOLUME = 4000;

	
	public Musica() {
		oitava = DEFAULT_OITAVA;
		instrumento = DEFAULT_INSTRUMENTO;
		bpm = DEFAULT_BPM;
		volume = DEFAULT_VOLUME;
	}
	
	public int getMaxVolume() {
		return MAX_VOLUME;
	}
	
	public int getMaxBpm() {
		return MAX_BPM;
	}
	
	public int getMaxOitava() {
		return MAX_OITAVA;
	}
	
	public int getMaxInstrumento() {
		return MAX_INSTRUMENTO;
	}	
	
	public int getInstrumento() {
		return instrumento;
	}
	
	public int getOitava() {
		return oitava;
	}
	
	public void setOitavaDefault() {
		oitava = DEFAULT_OITAVA;
	}
	
	public int getBpm() {
		return bpm;
	}
	
	public int getVolume() {
		return volume;
	}
	
	public void aumentaVolume(double valor) {
		if (volume == 0) {
			volume = 1;
		} else if((volume + (int)(volume*valor)) < MAX_VOLUME) {
			volume = volume + (int)(volume*valor);
		}
	}
	
	public void metadeVolume() {
		if(volume/2 > 0) {
			volume /= 2;
		}
	}
	
	public void aumentaOitava() {
		if (oitava < MAX_OITAVA) {
			oitava += 1;
		}
	}
	
	public void diminuiOitava() {
		if (oitava > 0) {
			oitava -= 1;
		}
	}
	
	public void aumentaRitmo() {
		if (bpm+50 < MAX_BPM) {
			bpm += 50;
		}
	}
	
	public void diminuiRitmo() {
		if (bpm-50 > 0) {
			bpm -= 50;
		}
	}
	
	public void trocarInstrumento(int valor) {
		if ((instrumento + valor) <= MAX_INSTRUMENTO) {
			instrumento += valor;
		}
	}
	
	public void trocarInstrumento(Instrumento instrumentoEscolhido) {
		switch(instrumentoEscolhido) {
		case HARPSICHORD:
			instrumento = 6;
			break;
		case TUBULAR_BELLS:
			instrumento = 14;
			break;
		case PAN_FLUTE:
			instrumento = 75;
			break;
		case CHURCH_ORGAN:
			instrumento = 19;
			break;
		}
	}
}
