package Esercizio1;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.SortedSet;

public class GeneratoreRandom {

	public GeneratoreRandom() {
	}

	static LinkedList<Integer> creaRandom(int n, int max){
		LinkedList<Integer> temp = new LinkedList<Integer>();
		Random rand = new Random();
		
		// scorro per n volte
		for(int i = 0; i < n; i++)
			temp.add(rand.nextInt(max));
		
		
		return temp;	
		
	}
	
	static void stampa(Iterator<Integer> i) {
		// fino a che ho elementi
		while(i.hasNext()) {
			//li stampo
			System.out.print(i.next() + " ");
		}
		System.out.println("");
	}
	
	static void provaEx1() {
		// array non ordinato
		LinkedList<Integer> ar1 = creaRandom(20, 51);
		
		System.out.println("Stampo array non ordinato");
		stampa(ar1.iterator());
		
		
		// array ordinato
		Comparator<Integer> com = null;
		ar1.sort(com);
		
		System.out.println("Stampo array ordinato");
		stampa(ar1.iterator());
		
		
	}
	

	
}
