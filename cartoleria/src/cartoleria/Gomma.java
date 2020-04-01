package cartoleria;

public final class Gomma extends Articolo{
	
	private Dimensione dimensione;
	private String forma;

	
	public Gomma(String marca, String modello, float costo, Dimensione dimensione, String forma) {
		super(marca, modello, costo);
		this.dimensione = dimensione;
		this.forma = forma;
	}


	@Override
	public String toString() {
		return "Gomma = " + super.toString() + " Dimensione: " + dimensione.toString() + " Forma: " + forma;
	}
}
