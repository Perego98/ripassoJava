package esercizio4;

import esercizio3.Vehicle;

public class Garage{

	public Garage() {
	}
	
	public float repair(Vehicle veicolo) {
		
		float prezzo = 0;
		boolean guasta = veicolo.isGuasta();
	
		// utilizzo la lunghezza della stringa che descrive
		// il modello per edcidere di quanto moltiplicare
		// il prezzo, facendolo variare appunto in base al modello
		// oltre che al parametro guasta
		if(guasta) {
			prezzo += 300 * veicolo.getModello().length();
			prezzo = prezzo/2.5f;
			veicolo.setGuasta(false);
		}
		else {
			prezzo += 100 * veicolo.getModello().length();
			prezzo = prezzo/2.5f;
		}
		
		return prezzo;
	}
	

}
