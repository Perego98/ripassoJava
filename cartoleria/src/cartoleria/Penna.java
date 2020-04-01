package cartoleria;

public final class Penna extends Articolo{
	private String colore;
	
	public Penna(String marca, String modello, float costo, String colore) {
		super(marca, modello, costo);
		this.colore = colore;
	}

	@Override
	public String toString() {
		return "Penna = " + super.toString() + " Colore: " + colore;
	}
	
	

}
