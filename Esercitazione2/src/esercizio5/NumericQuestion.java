package esercizio5;

import java.util.Scanner;

public class NumericQuestion extends Question{

	public NumericQuestion(String domanda, String risposta_corretta, int punteggio) {
		super(domanda, risposta_corretta, punteggio);
	}

	@Override
	public int ask() {
		Scanner input_numeric = new Scanner(System.in);
		
		System.out.println("Domanda: " + getDomanda());
		System.out.println("Inserisci un valore intero...");
		System.out.print("Risposta: ");
		String risp = "";
		try {
			risp = String.valueOf(input_numeric.nextInt());
		}
		catch(Exception e) {
			System.out.println("Eccezione generata: " + e.getCause() + "\nLa risposta sarà considerata come errata!");
		}
		
		
		if(risp.equalsIgnoreCase(getRisposta_corretta()))
			return getPunteggio();

		
		return 0;
	}
	
	

}
