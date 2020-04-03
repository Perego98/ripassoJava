package esercizio3;

public class Vehicle {

	private String targa;
	private String marca;
	private String modello;
	private boolean guasta;
	
	public Vehicle(String targa, String marca, String modello, boolean guasta) {
		super();
		this.targa = targa.toUpperCase(); // lo metto sempre in maiuscolo
		this.marca = marca;
		this.modello = modello;
		this.guasta = guasta;
	}

	public boolean isGuasta() {
		return guasta;
	}

	public void setGuasta(boolean guasta) {
		this.guasta = guasta;
	}

	public String getTarga() {
		return targa;
	}

	@Override
	public String toString() {
		return "targa=" + targa + ", marca=" + marca + ", modello=" + modello + ", guasta=" + guasta;
	}
	
	
	
}
