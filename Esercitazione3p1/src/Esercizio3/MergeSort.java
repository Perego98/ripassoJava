package Esercizio3;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import Esercizio1.GeneratoreRandom;

public class MergeSort {

	public MergeSort() {
		// TODO Auto-generated constructor stub
	}

	static LinkedList<Integer> mergeOrdinato(Iterator<Integer> a, Iterator<Integer> b){
		LinkedList<Integer> temp = new LinkedList<Integer>();
		Comparator<Integer> com = null;
		
		// sfrutto il motodo sort
		
		// riempio temp
		while(a.hasNext()) {
			temp.add(a.next());
		}
		
		while(b.hasNext()) {
			temp.add(b.next());
		}
		
		// poi ordino temp con il sort
		temp.sort(com);
		
			
			
		
			
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
	
	static void provaEx3() {
		LinkedList<Integer> ar1 = new LinkedList<Integer>();
		LinkedList<Integer> ar2 = new LinkedList<Integer>();
		LinkedList<Integer> merge = null;
		Comparator<Integer> com = null;
		Random rand = new Random();
		
		// riempio ar1
		for(int i = 0; i < 30; i++)
			ar1.add(rand.nextInt(1000));
		
		// lo ordino
		ar1.sort(com);
		
		// riempio ar2
		for(int i = 0; i < 30; i++)
			ar2.add(rand.nextInt(1000));
		
		// lo ordino
		ar2.sort(com);
		
		// unisco i due vettori
		merge = mergeOrdinato(ar1.iterator(), ar2.iterator());
		
		System.out.println("Stampo ar1:");
		stampa(ar1.iterator());
		
		System.out.println("Stampo ar2:");
		stampa(ar2.iterator());
		
		System.out.println("Stampo merge:");
		stampa(merge.iterator());
		
		
		
	}
}
