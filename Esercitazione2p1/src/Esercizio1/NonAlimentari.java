package Esercizio1;

import java.util.Date;

public class NonAlimentari extends Prodotti{

	private String materiale;

	public NonAlimentari(int codice_barre, String descrizione, float prezzo_unitario, String materiale) {
		super(codice_barre, descrizione, prezzo_unitario);
		this.materiale = materiale;
	}

	@Override
	public void applicaSconto() {
		
		if(materiale.equalsIgnoreCase("carta") || materiale.equalsIgnoreCase("vetro") || materiale.equalsIgnoreCase("plastica"))
			setPrezzo_unitario(getPrezzo_unitario() - (getPrezzo_unitario() * 10)/100);
	}

	@Override
	public String toString() {
		return super.toString() + "materiale=" + materiale;
	}
	
	
	
	
}
