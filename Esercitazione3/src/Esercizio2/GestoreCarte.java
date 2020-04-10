package Esercizio2;

import java.util.ArrayList;

public class GestoreCarte{

	private ArrayList<TesseraDiCredito> tessere;

	public GestoreCarte() {
		tessere = new ArrayList<TesseraDiCredito>();
	}
	
	public void caricaTessera(int codice, float ricarica) throws TesseraNonValida {
		
		boolean trovato = false;
		for(TesseraDiCredito tes: tessere) {
			if(tes.getCodice() == codice) {
				trovato = true;
				tes.setCredito(tes.getCredito() + ricarica);
			}
		}
		
		if(!trovato)
			throw new TesseraNonValida("Eccezione in CaricaTessera, tessera non trovata");
		
	}
	
	public void scalaCredito(int codice, float scala) {
		
		for(TesseraDiCredito tes: tessere) {
			if(tes.getCodice() == codice) {
				tes.setCredito(tes.getCredito() - scala);
			}
		}
	}
	
	public float leggiCredito(int codice) throws TesseraNonValida {
		
		boolean trovato = false;
		float credito = 0f;
		for(TesseraDiCredito tes: tessere) {
			if(tes.getCodice() == codice) {
				trovato = true;
				credito = tes.getCredito();
			}
		}
		
		if(!trovato)
			throw new TesseraNonValida("Eccezione in CaricaTessera, tessera non trovata");
		
		return credito;
	}
	
	public void addCarta(int codice) {
		
		boolean giaInserita = false;
		
		for(TesseraDiCredito tes: tessere) {
			if(tes.getCodice() == codice)
				giaInserita = true;
		}
		
				
		if(!giaInserita)
			tessere.add(new TesseraDiCredito(codice));
		else
			System.out.println("Tessera gia inserita");
		
	}

	public boolean exist(int codice) {
		boolean exist = false;
		
		for(TesseraDiCredito tes: tessere) {
			if(tes.getCodice() == codice)
				exist = true;
		}
		return exist;
	}
	
	@Override
	public String toString() {
		String result = "GestoreCarte\n";
		
		for(TesseraDiCredito tes: tessere) {
			result += tes.toString() + "\n";
		}
		return result;
	}
	
	
	
}
