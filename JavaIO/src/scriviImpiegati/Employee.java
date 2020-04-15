package scriviImpiegati;

import java.io.Serializable;

public class Employee implements Serializable{

	private static final long serialversionUId=1;
	private String surname;
	private String name;
	private int annoAssunzione;
	private float stipendio;
	
	
	public Employee(String surname, String name, int annoAssunzione, float stipendio) {
		this.surname = surname;
		this.name = name;
		this.annoAssunzione = annoAssunzione;
		this.stipendio = stipendio;
	}


	@Override
	public String toString() {
		return "Employee [surname=" + surname + ", name=" + name + ", annoAssunzione=" + annoAssunzione + ", stipendio="
				+ stipendio + "]";
	}
	
	
	
	
	
	
	
}
