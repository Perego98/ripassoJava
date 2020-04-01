package cartoleria;

public class Dimensione {

	private float lunghezza;
	private float altezza;
	private float larghezza;
	
	
	public Dimensione(float lunghezza, float altezza, float larghezza) {
		this.lunghezza = lunghezza;
		this.altezza = altezza;
		this.larghezza = larghezza;
	}


	@Override
	public String toString() {
		return "[lunghezza: " + lunghezza + ", altezza: " + altezza + ", larghezza: " + larghezza + "]";
	}
	
	


}
