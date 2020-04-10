package esercizio4;

import Esercizio1.BevandaNonValida;
import Esercizio2.TesseraNonValida;

public class testErogazione {

	
	
	public static void main(String[] args) {
		
		Erogazione erog = new Erogazione();
		System.out.println(erog.toString());	
		
		try {
			// erogo prodotto con codice A e pago con carta 1
			

			System.out.println("Colonna: " + erog.eroga("A", 1));
			System.out.println("Colonna: " + erog.eroga("C", 1));
			
			// qui non dovrei avere piu coche disponibili
			System.out.println("Colonna: " + erog.eroga("C", 1));
			
			
			
			
		} catch (TesseraNonValida | BevandaNonValida e ) {
			System.out.println(e.getMessage());
		}
		catch ( BevandaEsaurita | CreditoInsufficiente e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
		
			
			// svuoto la carta 2
			System.out.println("Colonna: " + erog.eroga("B", 2));
			System.out.println("Colonna: " + erog.eroga("B", 2));
			System.out.println("Colonna: " + erog.eroga("B", 2));
			
			// con questa erogazione avrò un errore perchè il credito non è abbastanza
			System.out.println("Colonna: " + erog.eroga("B", 2));
			
			// sbaglio codice lattina
			System.out.println("Colonna: " + erog.eroga("F", 1));
			
			// sbaglio codice carta
			System.out.println("Colonna: " + erog.eroga("A", 5));
			
			// sbaglio codice lattina e carta
			System.out.println("Colonna: " + erog.eroga("F", 5));
			
			
		} catch (TesseraNonValida | BevandaNonValida e ) {
			System.out.println(e.getMessage());
		}
		catch ( BevandaEsaurita | CreditoInsufficiente e) {
			System.out.println(e.getMessage());
		}
		
		try {
		
			
			// sbaglio codice lattina
			System.out.println("Colonna: " + erog.eroga("F", 1));
			
			
		} catch (TesseraNonValida | BevandaNonValida e ) {
			System.out.println(e.getMessage());
		}
		catch ( BevandaEsaurita | CreditoInsufficiente e) {
			System.out.println(e.getMessage());
		}
		
		try {			
			// sbaglio codice carta
			System.out.println("Colonna: " + erog.eroga("A", 5));
			
			
		} catch (TesseraNonValida | BevandaNonValida e ) {
			System.out.println(e.getMessage());
		}
		catch ( BevandaEsaurita | CreditoInsufficiente e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(erog.toString());

	}

}
