package esercizio1;

import java.util.Calendar;

public class Stagista extends Person{

	private int numberOfPresence;
	private int idNumber;
	
	public Stagista(int numberOfPresence, int idNumber) {
		super();
		this.numberOfPresence = numberOfPresence;
		this.idNumber = idNumber;
	}
	
	public Stagista(String surname, String name, String tax_code, String city, int numberOfPresence, int idNumber) {
		super(surname, name, tax_code, city);
		this.numberOfPresence = numberOfPresence;
		this.idNumber = idNumber;
	}

	public int getNumberOfPresence() {
		return numberOfPresence;
	}

	public void setNumberOfPresence(int numberOfPresence) {
		this.numberOfPresence = numberOfPresence;
	}

	public int getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}
	
	public Calendar getDataNascita() {
		// DNL PRG 80 A 01 D286A
		// DNLPRG80A01D286A --> NATO NEL 01/01/1980
		// DNLPRG19A01D286Q --> NATO NEL 01/01/2019
		Calendar nascita =  Calendar.getInstance();
		String cf = getTax_code();
		
		int giorno = Integer.valueOf(cf.substring(9, 11));
		int mese = calcolaMese(cf.charAt(8));
		int anno = bornYear();
		
		nascita.set(anno, mese, giorno);
		
		return nascita;
	}
	
	
	
	@Override
	public String toString() {
		return super.toString() + ", numberOfPresence=" + numberOfPresence + ", idNumber=" + idNumber;
	}

	private int calcolaMese(char lettera) {
		int mese = 0;
		switch(lettera){
		case 'A': mese = 1;
			break;
		case 'B': mese = 2;
			break;
		case 'C': mese = 3;
			break;
		case 'D': mese = 4;
			break;
		case 'E': mese = 5;
			break;
		case 'H': mese = 6;
			break;
		case 'L': mese = 7;
			break;
		case 'M': mese = 8;
			break;
		case 'P': mese = 9;
			break;
		case 'R': mese = 10;
			break;
		case 'S': mese = 11;
			break;
		case 'T': mese = 12;
			break;
		default:
			break;
		}
		
		return mese;
	}
	
	
}
