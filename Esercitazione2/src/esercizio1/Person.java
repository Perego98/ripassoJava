package esercizio1;

import java.util.GregorianCalendar;

public class Person {

	private String surname;
	private String name;
	private String tax_code;
	private String city;
	
	public Person() {
		this.surname = null;
		this.name = null;
		this.tax_code = null;
		this.city = null;
	}
	
	
	public Person(String surname, String name, String tax_code, String city) {
		this.surname = surname;
		this.name = name;
		this.tax_code = tax_code.toUpperCase();
		this.city = city;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTax_code() {
		return tax_code;
	}


	public void setTax_code(String tax_code) {
		this.tax_code = tax_code.toUpperCase();
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}
	
	public int bornYear() {
		// DNLPRG80A01D286A --> NATO NEL 1980
		// DNLPRG19A01D286Q --> NATO NEL 2019
		// nessun adifferenza tra 19xx e 20xx
		// ipotizzo che se ottengo numeri piu grandi delle ultime due cifre dell'anno corrente
		// si intende 19xx, se invece ottengo un numero
		//  tra 0 e ultime due cifre anno corrente sarà 20xx
		int anno_corrente = GregorianCalendar.getInstance().getWeekYear();
		
		// tengo solo le ultime due cifre
		anno_corrente = anno_corrente % 100;
		
		int cifreAnno = Integer.valueOf(tax_code.substring(6, 8));
		if(cifreAnno < anno_corrente)
			return 2000 + cifreAnno;
		else
			return 1900 + cifreAnno;
	}


	@Override
	public String toString() {
		return "surname=" + surname + ", name=" + name + ", tax_code=" + tax_code + ", city=" + city;
	}
	
	
	

}
