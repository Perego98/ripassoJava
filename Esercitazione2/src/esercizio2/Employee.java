package esercizio2;

import esercizio1.Person;

public class Employee extends Person{

	private int annoAssunzione;
	private float stipendio;
	
	
	public Employee(String surname, String name, String tax_code, String city, int annoAssunzione, float stipendio) {
		super(surname, name, tax_code, city);
		this.annoAssunzione = annoAssunzione;
		this.stipendio = stipendio;
	}


	public Employee(int annoAssunzione, float stipendio) {
		super();
		this.annoAssunzione = annoAssunzione;
		this.stipendio = stipendio;
	}

	public void visualize() {
		System.out.println("Dipendente: " + toString());
	}


	public int getAnnoAssunzione() {
		return annoAssunzione;
	}


	public float getStipendio() {
		return stipendio;
	}

	public boolean gainsMore(Employee emp1) {
		if(stipendio > emp1.getStipendio()) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", annoAssunzione=" + annoAssunzione + ", stipendio=" + stipendio;
	}
	
	
	
	
	
}
