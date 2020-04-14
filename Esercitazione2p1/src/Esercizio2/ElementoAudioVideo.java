package Esercizio2;

public abstract class ElementoAudioVideo implements luminosita, volume, ElementoMultimediale {

	
	private int luminosita;
	private int volume;
	private int durata;
	private String titolo;
	
	@Override
	public int getLuminosita() {
		return luminosita;
	}

	public int getVolume() {
		return volume;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	@Override
	public void setTitolo(String _titolo) {
		titolo = _titolo;		
	}

	@Override
	public String getTitolo() {
		return titolo;
	}

	@Override
	public void weaker() {
		if(volume < 100)
			volume++;

	}

	@Override
	public void louder() {
		if(volume > 0)
			volume++;

	}

	@Override
	public void darker() {
		if(luminosita > 0)
			luminosita--;

	}

	@Override
	public void brighter() {
		if(luminosita < 100)
			luminosita++;
	}

	public abstract void play();


}
