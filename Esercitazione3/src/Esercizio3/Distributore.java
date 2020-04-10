package Esercizio3;

import java.util.Arrays;

import Esercizio1.Bevanda;
import Esercizio1.BevandaNonValida;

public class Distributore {

	private final static int numeroColonne = 4;
	Colonna [] distributore;

	public Distributore() {
		distributore = new Colonna[numeroColonne];
		
		// inizializzo con colonne vuote
		for(int i = 0; i < distributore.length; i++) {
			distributore[i] = new Colonna();
		}
	}
	
	public void aggiornaColonna(int codColonna, Bevanda bevanda, int numLattine) {
		if(codColonna-1 >= 0 && codColonna-1 < distributore.length) {
			distributore[codColonna-1].aggiornaColonnaC(codColonna-1, bevanda, numLattine);
		}
		else
			System.out.println("Colonna non presente, inserimento fallito");
	}
	
	public int lattineDisponibili(String codice) throws BevandaNonValida {
		int somma = 0;
		boolean trovato = false;
		// scorro le colonne e prendo il numero di lattine solo dalle colonne
		// che contengono il tipo di lattina cercato
		for(int i = 0; i < distributore.length; i++) {
			String cod1 = distributore[i].getCodeBevanda();
			if(cod1.equalsIgnoreCase(codice)) {
				trovato = true;
				somma += distributore[i].lattineDisponibili();
			}
		}
		
		if(!trovato) {
			throw new BevandaNonValida("Eccezione in lattineDisponibili, codice bevanda non trovato, codice: " + codice);
		}
		
		return somma;
		
		
	}

	public int colonnaLattina(String codice) {
		
		boolean trovato = false;
		int codColonna = -1;
		for(int i = 0; i < distributore.length && !trovato; i++) {
			String cod1 = distributore[i].getCodeBevanda();
			if(cod1.equalsIgnoreCase(codice)) {
				if(distributore[i].lattineDisponibili() > 0) {
					codColonna = i;
					trovato = true;
				}					
			}			
		}
		return codColonna;
	}
	
	public boolean eroga(int codColonna) {
		if(codColonna >= 0 && codColonna < distributore.length) {
			if(!distributore[codColonna].decrementa(1)) {
				System.out.println("Decremento Fallito");
				return false;
			}				
		}
		else {
			System.out.println("Codice non valido: " + codColonna);
			return false;
		}
			
		
		return true;
	}
	
	public float getPrezzoBevanda(String codice) {
		
		for(int i = 0; i < distributore.length; i++) {
			String cod1 = distributore[i].getCodeBevanda();
			if(cod1.equalsIgnoreCase(codice)) {
				return distributore[i].getPrezzoBevandaC();
			}
		}
		
		return 0f;
	}
	
	public boolean exist(String codice) {
		boolean exist = false;
		for(int i = 0; i < distributore.length && !exist; i++) {
			String cod1 = distributore[i].getCodeBevanda();
			if(cod1.equalsIgnoreCase(codice)) {
				exist = true;
			}
		}
			return exist;
	}
		
	
	@Override
	public String toString() {
		String result = "Distributore:\n";
		for(int i = 0; i < distributore.length; i++) {
			result += distributore[i].toString() + "\n";
		}
		
		return result;
	}
	
	
	
	
}
