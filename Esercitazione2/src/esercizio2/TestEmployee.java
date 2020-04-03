package esercizio2;

import esercizio1.Stagista;

public class TestEmployee {

	static void creaDipendenti(Employee [] dipendenti) {
		dipendenti[0] = new Employee("Perego", "Daniele", "PRGDNL98R06D286W", "Cesano Maderno", 2000, 5);// 06/10/1998
		dipendenti[1] = new Employee("Golia", "Davide", "GLODVD39E13D286N", "Desio", 1967, 100); // 13/05/1939
		dipendenti[2] = new Employee("Franco", "Lucia", "FRNLCU11A01D286P", "Desio", 2017, 15); // 01/01/2011
	}
	
	static void sortByStipendio(Employee [] dipendenti) {
		// sort
				Employee temp;
				for (int i = 1; i < dipendenti.length; i++) {//ciclo che scorre in avanti
					for (int j = i; j > 0; j--) {// ciclo che scorre all'indietro incrementando di uno ogni volta
						if (!dipendenti[j].gainsMore(dipendenti[j - 1])) {
							// swap
							temp = dipendenti[j];
							dipendenti[j] = dipendenti[j - 1];
							dipendenti[j - 1] = temp;
						}
					}
				}
	}
	
	static void stampa(Employee [] dipendenti) {
		for(int i = 0; i < dipendenti.length; i++) {
			dipendenti[i].visualize();
		}
	}
	
	public static void main(String[] args) {
		
		Employee [] dipendenti = new Employee[3];
		
		creaDipendenti(dipendenti);
		
		sortByStipendio(dipendenti);
		
		stampa(dipendenti);
		
		
		
	}

}
