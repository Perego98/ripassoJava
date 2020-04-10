package Esercizio1;

public class testBevande {

	public static void main(String[] args){
		
		gestoreBevande gestBevande = new gestoreBevande();
		gestBevande.aggiungiBevanda("A", "CocaCola", 0.30f);
		gestBevande.aggiungiBevanda("B", "Acqua", 0.10f);
		gestBevande.aggiungiBevanda("C", "Birra", 1.50f);
		
		// genero stampa messaggio
		gestBevande.aggiungiBevanda("C", "Burro", 1.50f);
		
		try {
			System.out.println(gestBevande.getName("A"));
			System.out.println(gestBevande.getPrice("A"));
			System.out.println(gestBevande.getName("B"));
			System.out.println(gestBevande.getPrice("B"));
			System.out.println(gestBevande.getName("C"));
			System.out.println(gestBevande.getPrice("C"));
			
			
			System.out.println(gestBevande.getName("D"));
		}
		catch(BevandaNonValida e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
