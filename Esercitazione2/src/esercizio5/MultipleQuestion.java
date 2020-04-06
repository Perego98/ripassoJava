package esercizio5;

import java.util.Scanner;

public class MultipleQuestion extends NumericQuestion{

	private String possibili_risposte;// separate da ,

	public MultipleQuestion(String domanda, String risposta_corretta, String possibili_risposte, int punteggio) {
		super(domanda, risposta_corretta, punteggio);
		this.possibili_risposte = possibili_risposte;
	}

	@Override
	public int ask() {
		Scanner input_multiple = new Scanner(System.in);
		
		System.out.println("Domanda: " + getDomanda());
		// stampa delle possibili risposte
		
		// tolgo eventuali sapzzi
		possibili_risposte.replaceAll(" ", "");
		
		// separo le possibili risposte
		String [] elenco = possibili_risposte.split(",");
		
		// stampo opzione corretta
		System.out.println("1) " + getRisposta_corretta());
		
		// stampo altre opzioni
		for(int i = 0; i < elenco.length; i++) {
			System.out.println(i+2 + ") " + elenco[i].replace(" ", ""));		
		}		
		
		System.out.println("Inserisci il numero della risposta...");
		System.out.print("Risposta: ");
		
		int temp = -1;
		try {
			temp = input_multiple.nextInt();
		}
		catch(Exception e) {
			System.out.println("Eccezione generata: " + e.getCause() + "\nLa risposta sarà considerata come errata!");
		}
				
		if(temp == 1)
			return getPunteggio();

		
		return 0;

	}
	
	
	
	
	

}
