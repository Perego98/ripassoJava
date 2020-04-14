package Esercizio4;

import java.util.Iterator;
import java.util.LinkedList;



public class Insiemi {

	static LinkedList<LinkedList<Integer>> insiemeDiInsiemi(int n){
		LinkedList<LinkedList<Integer>> temp = new LinkedList<LinkedList<Integer>>();
		
		// inserimento
		for(int i = 0; i< n; i++) {
			LinkedList<Integer> inserimento = new LinkedList<Integer>();
			
			for(int j = 0; j < i+1; j++) {
				inserimento.add(j);
			}
			
			temp.add(inserimento);
		}
		
	
		
		
		return temp;
	}
	
	static void stampa(LinkedList<LinkedList<Integer>> a){
		
		// scorro il vettore di vettori
		for(int i = 0; i < a.size(); i++) {
			// prendo l'i-esimo vettore
			Iterator<Integer> iter = a.get(i).iterator();
			
			// lo scorro e lo stampo
			while(iter.hasNext()) {
				System.out.print(iter.next() + " ");
			}
			
			System.out.println("");
		}	
	}
	
	static void provaEx4() {
		stampa(insiemeDiInsiemi(100));		
	}
}
