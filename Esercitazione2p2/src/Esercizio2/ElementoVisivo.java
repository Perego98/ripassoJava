package Esercizio2;

public abstract class ElementoVisivo implements ElementoMultimediale, luminosita {

	private int luminosita;
	private String titolo;
	
	
	public int getLuminosita() {
		return luminosita;
	}

	@Override
	public void darker() {
		if(luminosita > 0)
			luminosita--;

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
	public void brighter() {
		if(luminosita < 100)
			luminosita++;
	}

	public abstract void show();
}
