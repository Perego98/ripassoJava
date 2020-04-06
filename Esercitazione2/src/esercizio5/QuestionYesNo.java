package esercizio5;

import java.util.Scanner;

public class QuestionYesNo extends Question{


	public QuestionYesNo(String domanda, String risposta_corretta, int punteggio) {
		super(domanda, risposta_corretta.toLowerCase(), punteggio);
	}

	@Override
	public int ask() {
		
		Scanner input_yesno = new Scanner(System.in);
		
		System.out.println("Domanda: " + getDomanda());
		System.out.println("Scrivi si/no per rispondere...");
		System.out.print("Risposta: ");
		String risp = input_yesno.next();
		
		// metto tutto in minuscolo per evitare errori
		risp.toLowerCase();
		
		if(risp.equalsIgnoreCase(getRisposta_corretta()))
			return getPunteggio();

		
		return 0;
	}
	
	
	
	
	

}
