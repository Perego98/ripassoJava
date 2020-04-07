package Esercizio2;

import java.util.Scanner;

public class LettoreMultimediale {

	static void inserimento(ElementoMultimediale [] lettore) {
		Scanner input_inserimento = new Scanner(System.in);
		boolean finito = false;
		int ins = 0;
		
		do {
			if(!finito) {
				System.out.println("1) crea immagine\n2) crea video\n3) crea audio");
				try {
					System.out.print("Input: ");
					ins = input_inserimento.nextInt();
				}
				catch(Exception e) {
					System.out.println("Input non valido");
				}
				
				if(ins == 0)
					finito = true;
				else if(ins < 0 || ins > lettore.length)
					System.out.println("Posizione non valida");
				else {
					boolean inserito = false;
					for(int i = 0; i < lettore.length && !inserito; i++) {
						if(lettore[i] == null) {
							if(ins == 1)
								lettore[i] = creaImmagine();
							else if(ins == 2)
								lettore[i] = creaVideo();
							else if(ins == 3)
								lettore[i] = creaAudio();
							inserito = true;
						}
					}
					
					// se il vettore è pieno ho finito
					if(!inserito)
						finito = true;
				}
		}
			
		}while(!finito);
	}
	
	static Immagine creaImmagine() {
		Scanner input = new Scanner(System.in);
		String titolo = null;
		System.out.println("Creazione immagine...");
		
		try {
			System.out.print("Titolo: ");
			titolo = input.nextLine();
		}
		catch(Exception e) {
			System.out.println("Errore di inserimento...");
		}
		
		
		return new Immagine(titolo);
	}
	
	static Filmato creaVideo() {
		Scanner input = new Scanner(System.in);
		String titolo = null;
		int durata = 0;
		System.out.println("Creazione video...");
		
		try {
			System.out.print("Titolo: ");
			titolo = input.nextLine();
		}
		catch(Exception e) {
			System.out.println("Errore di inserimento...");
		}
		
		try {
			System.out.print("Durata: ");
			durata = input.nextInt();
		}
		catch(Exception e) {
			System.out.println("Errore di inserimento...");
		}
		
		
		return new Filmato(titolo, durata);
	}
	
	static RegistrazioneAudio creaAudio() {
		Scanner input = new Scanner(System.in);
		String titolo = null;
		int durata = 0;
		System.out.println("Creazione Registrazione Audio...");
		
		try {
			System.out.print("Titolo: ");
			titolo = input.nextLine();
		}
		catch(Exception e) {
			System.out.println("Errore di inserimento...");
		}
		
		try {
			System.out.print("Durata: ");
			durata = input.nextInt();
		}
		catch(Exception e) {
			System.out.println("Errore di inserimento...");
		}
		
		
		return new RegistrazioneAudio(titolo, durata);
	}
	
	static void esegui(ElementoMultimediale [] lettore) {
		Scanner input = new Scanner(System.in);
		
		boolean finito = false;
		int ins = 0;
		do {
			stampa(lettore);
			System.out.println("inserisci il numero dell'elemento da visualizzare...\n 0 per uscire");
			try {
				System.out.print("Numero: ");
				ins = input.nextInt();
			}
			catch(Exception e) {
				System.out.println("Input non valido");
			}
			
			if(ins == 0)
				finito = true;
			else if(ins-1 < 0 || ins-1 > lettore.length)
				System.out.println("Posizione non valida");
			else {
				ins--;
				if(lettore[ins] != null) {
					if(lettore[ins].getClass() == new Immagine().getClass())
						eseguiImmagine((Immagine) lettore[ins]);
					else if(lettore[ins].getClass() == new RegistrazioneAudio().getClass())
						eseguiAudio((RegistrazioneAudio) lettore[ins]);
					else if(lettore[ins].getClass() == new Filmato().getClass())
						eseguiFilmato((Filmato) lettore[ins]);
				}
			}
			
		}while(!finito);
		
	}
	
	static void eseguiAudio(RegistrazioneAudio temp) {
		Scanner input = new Scanner(System.in);
		boolean finito = false;
		int ins = 0;
		temp.play();
		do {
			System.out.println("0)exit \n1) aumenta volume \n2) diminuisci volume");
			try {
				System.out.print("Scelta: ");
				ins = input.nextInt();
			}
			catch(Exception e) {
				System.out.println("Input non valido");
			}
			
			if(ins == 0)
				finito = true;
			else if(ins == 1) 
				temp.weaker();
			else if(ins == 2)
				temp.louder();
		}while(!finito);
	}
	
	static void eseguiFilmato(Filmato temp) {
		Scanner input = new Scanner(System.in);
		boolean finito = false;
		int ins = 0;
		temp.play();
		do {
			System.out.println("0)exit \n1) aumenta volume \n2) diminuisci volume\n3) aumenta luminosita' \n4) diminuisci luminosita'");
			try {
				System.out.print("Scelta: ");
				ins = input.nextInt();
			}
			catch(Exception e) {
				System.out.println("Input non valido");
			}
			
			if(ins == 0)
				finito = true;
			else if(ins == 1) 
				temp.weaker();
			else if(ins == 2)
				temp.louder();
			else if(ins == 3)
				temp.brighter();
			else if(ins == 4)
				temp.darker();
			
		}while(!finito);
	}
	
	static void eseguiImmagine(Immagine temp) {
		Scanner input = new Scanner(System.in);
		boolean finito = false;
		int ins = 0;
		temp.show();
		do {
			System.out.println("0)exit \n1) aumenta luminosita' \n2) diminuisci luminosita'");
			try {
				System.out.print("Scelta: ");
				ins = input.nextInt();
			}
			catch(Exception e) {
				System.out.println("Input non valido");
			}
			
			if(ins == 0)
				finito = true;
			else if(ins == 1)
				temp.brighter();
			else if(ins == 2)
				temp.darker();
			
		}while(!finito);
	}
	
	static void stampa(ElementoMultimediale [] lettore) {
		for(int i = 0; i < lettore.length; i++){
			if (lettore[i] != null) {
				System.out.println((i+1)+")" + lettore[i].toString());
			}
		}
	}
	
	public static void main(String[] args) {
		ElementoMultimediale [] lettore = new ElementoMultimediale[5];
		
		inserimento(lettore);

		esegui(lettore);
	}

}
