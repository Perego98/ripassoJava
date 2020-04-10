package Esercizio3;

import Esercizio1.Bevanda;
import Esercizio1.BevandaNonValida;

public class testDistributore {

	public static void main(String[] args) {
		
		Distributore dist = new Distributore();
		
		dist.aggiornaColonna(1, new Bevanda("A", "Acqua", 0.10f), 40);
		dist.aggiornaColonna(2, new Bevanda("C", "CocaCola", 0.50f), 1);
		dist.aggiornaColonna(3, new Bevanda("B", "Birra", 2.50f), 50);
		dist.aggiornaColonna(4, new Bevanda("A", "Acqua", 0.10f), 50);
		
		// errore
		dist.aggiornaColonna(7, new Bevanda("A", "Acqua", 0.10f), 17);
		
		
		try {
			System.out.println("A " + dist.lattineDisponibili("A"));
			System.out.println("B " + dist.lattineDisponibili("B"));
			System.out.println("C " + dist.lattineDisponibili("C"));
			
			// eccezione
			System.out.println(dist.lattineDisponibili("F"));
		} catch (BevandaNonValida e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(dist.toString());
	}

}
