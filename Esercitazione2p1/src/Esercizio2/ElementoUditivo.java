package Esercizio2;

public abstract class ElementoUditivo implements ElementoMultimediale, volume {

	private int volume;
	private String titolo;
	private int durata;
	
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
		 this.titolo = _titolo;		
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

	public abstract void play();
}
