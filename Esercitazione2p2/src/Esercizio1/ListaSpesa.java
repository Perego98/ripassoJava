package Esercizio1;

import java.util.Date;
import java.util.Scanner;

public class ListaSpesa {

	static void rimepiElenco(Prodotti [] prodotti) {
		prodotti[0] = new Alimentari(17892734, "Mela", 2, new Date(2020, 3, 16));
		prodotti[1] = new Alimentari(16892734, "Banana", 2, new Date(2020, 3, 29));
		prodotti[2] = new NonAlimentari(90892734, "Cestino", 12, "plastica");
		prodotti[3] = new NonAlimentari(91892734, "fogli", 6, "carta");
		prodotti[4] = new NonAlimentari(96892734, "specchio", 150, "vetro");
		
	}
	static void stampaElenco(Prodotti [] prodotti) {
		for (int i = 0; i < prodotti.length; i++)
			System.out.println((i+1)+")" + prodotti[i].toString());
	}
	
	static void inserisci_articoli(Prodotti [] prodotti, Prodotti [] lista_spesa) {
		Scanner input = new Scanner(System.in);
		boolean finito = false;
		System.out.println("Inserire 0 per uscire...");
		
		// rimango nel ciclo fino a che l'utente non decide di uscire premendo 0
		do {
			stampaElenco(prodotti);
			System.out.print("Inserire codice articolo: ");
			int cod = 0;
			try {
				cod = input.nextInt();
			}
			catch(Exception e) {
				System.out.println("Inserimento non valido... uscita");
			}
			
			
			if (cod==0) // se preme 0 esco
				finito = true;
			else if(cod < 0 || (cod > prodotti.length || cod > lista_spesa.length))
			{ // altrimenti se sco dal limite stampo errore
				System.out.println("Inserimento non valido...");
			}
			else if(!find(lista_spesa, prodotti[cod-1])) {
				// altrimenti s enon ho gia inserito l'articolo lo inserisco
				boolean inserito = false;
				for(int i = 0; i < lista_spesa.length && !inserito; i++) {
					if(lista_spesa[i] == null) {
						lista_spesa[i] = prodotti[cod-1];
						inserito = true;
					}						
				}
			}
			
		}while(!finito);
		
		
	}
	static boolean find(Prodotti [] lista_spesa, Prodotti prodotto) {

		for (int i = 0; i < lista_spesa.length; i++) {
			if(prodotto.equals(lista_spesa[i])) {
				System.out.println("Prodotto gia inserito");
				return true;
			}
		}
		return false;
		
	}
	
	static void stampa_spesa(Prodotti [] lista_spesa) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Ha la tessera fedeltà?");
		System.out.print("si/no: ");
		String in = input.next();
		in.toLowerCase();
		boolean tessera = in.equals("si");
		float totale = 0;
		for(int i = 0; i < lista_spesa.length; i++) {
			if(lista_spesa[i] != null) {
				if(tessera) {
					lista_spesa[i].applicaSconto();
					totale += lista_spesa[i].getPrezzo_unitario();							
				}
				else {
					totale += lista_spesa[i].getPrezzo_unitario();		
				}
			}
		}
		
		System.out.println("Totale: " + totale);
	}
	public static void main(String[] args) {
		Prodotti [] prodotti = new Prodotti[5];
		Prodotti [] lista_spesa = new Prodotti[10];
		
		rimepiElenco(prodotti);
		inserisci_articoli(prodotti, lista_spesa);
		
		stampa_spesa(lista_spesa);

	}

}
