package Esercizio2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class GeneratoreRandom2 {
	
	
	

	public GeneratoreRandom2() {
		// TODO Auto-generated constructor stub
	}

	static LinkedList<Integer> creaRandomCrescente(int n){
		LinkedList<Integer> temp = new LinkedList<Integer>();
		Random rand = new Random();
		
		int prev = 0;
		// se il vettore è vuoto inserisco il primo elemento, casuale tra 0 e 100
		// se non lo è prendo l'ultimo elemnto sommato a un numero random casuale tra 0 e 100
		for( int i = 0; i < n; i++) {
			if(temp.isEmpty())
				prev = rand.nextInt(100);
			else
				prev = rand.nextInt(100) + temp.getLast();
			
			temp.add(prev);
		}
			
		return temp;
	}
	
	static LinkedList<Integer> parseString(LinkedList<String> a){
		LinkedList<Integer> temp = new LinkedList<Integer>();
		
		Iterator<String> iter = a.iterator();
		while(iter.hasNext()) {
			try {
				temp.add(Integer.parseInt(iter.next()));
			}
			catch(Exception e) {
				System.out.println("Eccezione: " + e.getMessage());
			}
					
		}
		
		
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
	
	static void stampaString(Iterator<String> i) {
		// fino a che ho elementi
		while(i.hasNext()) {
			//li stampo
			System.out.print(i.next() + " ");
		}
		System.out.println("");
	}
	
	static void provaEx2(){
		LinkedList<Integer> ar1 = creaRandomCrescente(20);
		LinkedList<String> ar2 = new LinkedList<String>();
		LinkedList<Integer> ar3 = null;
		
		// stampo ar1
		stampa(ar1.iterator());
		
		// popolo la lista di stringhe
		ar2.add("12");
		ar2.add("6");
		ar2.add("767");
		ar2.add("67");
		ar2.add("14");
		ar2.add("34");
		ar2.add("132");
		ar2.add("142");
		ar2.add("1e2");
		ar2.add("132");
		ar2.add("1352");
		ar2.add("13542");
		ar2.add("1dvfc2"); // genererà eccezione con ParseInt
		
		
		// stampo ar2
		stampaString(ar2.iterator());
		
		
		ar3 = parseString(ar2);
		
		// stampo ar3
		stampa(ar3.iterator());
		
		
	}
	
}
