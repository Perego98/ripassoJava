package Esercizio2;

public class testCredito {

	public static void main(String[] args) {
		
		GestoreCarte gestoreCard = new GestoreCarte();
		
		gestoreCard.addCarta(1);
		gestoreCard.addCarta(2);
		gestoreCard.addCarta(3);
		
		// errore
		gestoreCard.addCarta(1);
		
		try {
			gestoreCard.caricaTessera(1, 67.78f);
			System.out.println(gestoreCard.leggiCredito(1));
			gestoreCard.caricaTessera(2, 7.78f);
			System.out.println(gestoreCard.leggiCredito(2));
			gestoreCard.caricaTessera(3, 6.78f);
			System.out.println(gestoreCard.leggiCredito(3));
			gestoreCard.caricaTessera(4, 67.78f);
		} catch (TesseraNonValida e) {
			System.out.println(e.getMessage());
		}
		
		

	}

}
