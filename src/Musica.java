
public class Musica {
	private int oitava;
	private int instrumento;
	private int bpm;
	private int volume;
	
	public Musica() {
		oitava = Default.oitava;
		instrumento = Default.instrumento;
		bpm = Default.bpm;
		volume = Default.volume;
	}
	
	
	public int getInstrumento() {
		return instrumento;
	}
	
	public int getOitava() {
		return oitava;
	}
	
	public void setOitavaDefault() {
		oitava = Default.oitava;
	}
	
	public int getBpm() {
		return bpm;
	}
	
	public int getVolume() {
		return volume;
	}
	
	public void dobraVolume() {
		if (volume == 0) {
			volume = 2;
		} else if(volume*2 < 16383) {
			volume *= 2;
		}
	}
	
	public void metadeVolume() {
		if(volume/2 > 0) {
			volume /= 2;
		}
	}
	
	public void aumentaOitava() {
		if (oitava < 10) {
			oitava += 1;
		}
	}
	
	public void diminuiOitava() {
		if (oitava > 0) {
			oitava -= 1;
		}
	}
	
	public void aumentaRitmo() {
		if (bpm+50 < 10000) {
			bpm += 50;
		}
	}
	
	public void diminuiRitmo() {
		if (bpm-50 > 0) {
			bpm -= 50;
		}
	}
	
	public void trocarInstrumento() {
		if (instrumento < 4) {
			instrumento += 1;
		} else {
			instrumento = 0;
		}
	}
}
