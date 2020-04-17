package paghetta;

public class testPaghetta {

	
	public static void main(String[] args) {
		boolean mesePassato = true;
		boolean genVivo = false, fiVivo = false;
		Cassetto cassetto = new Cassetto();
		
		Figlio figlio = new Figlio("Samuele", cassetto);
		Figlio figlio2 = new Figlio("Daniele", cassetto);
		
		Genitore genitore = new Genitore("Attilio", cassetto);
		
		
		genitore.start();
		figlio.start();	
		
		// con due figli funziona ma Il primo figlio ad essere lanciato
		// accede molto piu di frequente
		//figlio2.start();
		
	
	}

}
