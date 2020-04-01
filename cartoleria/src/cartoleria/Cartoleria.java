package cartoleria;



public class Cartoleria {

	public static void main(String[] args) {
		Articolo[] magazzino = new Articolo[10];
		magazzino[0] = new Gomma("Mini", "Faber-Castel", 3, new Dimensione(5, 2, 3), "Parallelepipedo");
		magazzino[1] = new Penna("Bic", "Stilo", 2, "Nero");
		magazzino[2] = new Penna("Bic", "Stilo", 2, "Rosso");
		magazzino[3] = new Penna("Bic", "Stilo", 3, "Verde");
		magazzino[4] = new Penna("Bic", "Stilo", 1, "Blu");
		magazzino[5] = new Gomma("Normale", "Faber-Castel", 6, new Dimensione(5, 5, 8), "Parallelepipedo");
		magazzino[6] = new Gomma("Normale", "Bic", 3, new Dimensione(5, 5, 3), "Trapezio");
		magazzino[7] = new Gomma("Mini", "Faber-Castel", 3, new Dimensione(5, 2, 3), "Parallelepipedo");
		magazzino[8] = new Gomma("Mini", "Faber-Castel", 3, new Dimensione(5, 2, 3), "Parallelepipedo");
				
		
		for(int i = 0; i < magazzino.length ; i++)
			if (magazzino[i] != null) {
				System.out.println(magazzino[i].toString());
			}				
	}

}
