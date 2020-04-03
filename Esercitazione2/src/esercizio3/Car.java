package esercizio3;

public class Car extends Vehicle{
	
	private String tipo;

	public Car(String targa, String marca, String modello, boolean guasta, String tipo) {
		super(targa, marca, modello, guasta);
		this.tipo = tipo;
	}

	
	@Override
	public String toString() {
		return "Car: tipo=" + tipo + super.toString();
	}
	
	
	

}
