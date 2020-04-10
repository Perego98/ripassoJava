package Esercizio1;


import java.util.ArrayList;
import java.util.HashMap;

public class gestoreBevande {

	private HashMap<String, Bevanda> elenco;

	public gestoreBevande() {
		elenco = new HashMap<String, Bevanda>();
	}
	
	public void aggiungiBevanda(String codice, String nome, float prezzo) {
		
		// controllo che il codice sia univoco
		boolean presente = false;
		
		
		for(String key : elenco.keySet()) {
			if(key.equalsIgnoreCase(codice)) {
				presente = true;
			}
		}
		
		// se non è gia stato usato lo inserisco
		if(!presente)
			elenco.put(codice, new Bevanda(codice, nome, prezzo));
		else
			System.out.println("Codice " + codice + " gia presente");
	}
	
	public float getPrice(String codice) throws BevandaNonValida {
		
		boolean trovato = false;
		float prezzo = 0;
		for(String key : elenco.keySet()) {
			if(key.equalsIgnoreCase(codice)) {
				trovato = true;
				prezzo = elenco.get(key).getPrezzo();
			}
		}
		
		if(!trovato)
			throw new BevandaNonValida("Errore in getPrice, codice non trovato");
		
		return prezzo;
	}
	
	public String getName(String codice) throws BevandaNonValida {
		
		boolean trovato = false;
		String nome = "";
		for(String key : elenco.keySet()) {
			if(key.equalsIgnoreCase(codice)) {
				trovato = true;
				nome = elenco.get(key).getNome();
			}
		}
		
		if(!trovato)
			throw new BevandaNonValida("Errore in getName, codice non trovato");
		
		return nome;
	}

	@Override
	public String toString() {
		String result = "GestoreBevande\n";
		for(String key : elenco.keySet()) {
			result += elenco.get(key).toString() + "\n";
		}
		
		return result;
	}
	
	
	
}
