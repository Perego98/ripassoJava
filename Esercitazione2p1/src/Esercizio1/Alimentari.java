package Esercizio1;

import java.util.Date;

public class Alimentari extends Prodotti{

	private Date data_scadenza;

	public Alimentari(int codice_barre, String descrizione, float prezzo_unitario, Date data_scadenza) {
		super(codice_barre, descrizione, prezzo_unitario);
		this.data_scadenza = data_scadenza;
	}

	@Override
	public void applicaSconto() {
		Date oggi = new Date();// data di oggi
		
		// sbagliava ad inizializzare la data, metteva 120 e quindi i calcoli non funzionavano
		oggi.setYear(2020);
		long giorni =  ((data_scadenza.getTime() - oggi.getTime()) / 86400000L); // 
		
		// calcola un giorno in meno, quindi faccio +1
		if(giorni+1 < 10)
			setPrezzo_unitario(getPrezzo_unitario() - (getPrezzo_unitario() * 20)/100);
	}

	@Override
	public String toString() {
		return super.toString() + "data_scadenza=" + data_scadenza.toString();
	}
	
	
	
}
