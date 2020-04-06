package esercizio5;

import java.util.Scanner;

public class Question {

	private String domanda;
	private String risposta_corretta;
	private int punteggio;
	
	public Question() {
		this.domanda = null;
		this.risposta_corretta = null;
		this.punteggio = 1;
	}
	
	public Question(String domanda, String risposta_corretta, int punteggio) {
		this.domanda = domanda;
		this.risposta_corretta = risposta_corretta;
		this.punteggio = punteggio;
	}

	public String getDomanda() {
		return domanda;
	}

	public String getRisposta_corretta() {
		return risposta_corretta;
	}

	public int getPunteggio() {
		return punteggio;
	}

	public void setDomanda(String domanda) {
		this.domanda = domanda;
	}

	public void setRisposta_corretta(String risposta_corretta) {
		this.risposta_corretta = risposta_corretta;
	}

	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}
	
	
	public int ask() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Domanda: " + getDomanda());
		System.out.print("Risposta: ");
		String risp = input.nextLine();
		if(risp.equalsIgnoreCase(risposta_corretta))
			return punteggio;


		
		return 0;
	}
	
}
