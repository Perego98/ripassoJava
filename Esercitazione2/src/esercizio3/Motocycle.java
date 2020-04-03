package esercizio3;

public class Motocycle extends Vehicle{

	private int cilindrata;

	public Motocycle(String targa, String marca, String modello, boolean guasta, int cilindrata) {
		super(targa, marca, modello, guasta);
		this.cilindrata = cilindrata;
	}

	@Override
	public String toString() {
		return "Motocycle: cilindrata=" + cilindrata + super.toString();
	}
	
	
}
