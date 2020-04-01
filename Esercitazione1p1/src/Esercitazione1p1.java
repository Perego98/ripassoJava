
public class Esercitazione1p1 {

	static void esercizio1() {
		int [] array_interi = {10, 3, 4, 9, 6, 18, 23, 4 , 1, 32, 4, 56};
		
		int temp;
		for (int i = 1; i < array_interi.length; i++) {//ciclo che scorre in avanti
			for (int j = i; j > 0; j--) {// ciclo che scorre all'indietro incrementando di uno ogni volta
				if (array_interi[j] < array_interi [j - 1]) {
					// swap
					temp = array_interi[j];
					array_interi[j] = array_interi[j - 1];
					array_interi[j - 1] = temp;
				}
			}
		}

		System.out.println("Array ordinato: ");
		 for (int i = 0; i < array_interi.length; i++) {
		     System.out.print(array_interi[i] + " ");
		   }
		 System.out.println("");
	}
	
	// non considera gli sapzzi
	static boolean esercizio2_palindroma(String parola) {
		boolean palindroma = true;
		// rimuovo gli spazzi
		String parola_senza_spazzi = parola.replaceAll(" ", "");				

		
		//if(parola.length() % 2 == 0)
			for(int i = 0, j = parola_senza_spazzi.length()-1; i < parola_senza_spazzi.length()/2; i++, j--) {
				if(parola_senza_spazzi.charAt(i) != parola_senza_spazzi.charAt(j))
					palindroma=false;
			}
		
		
		return palindroma;
	}
	
	static void esercizio3(){
		
		// uso long al posto di int perchè i numeri di fibonacci 
		//tendono a diventare molto grandi ad ogni iterazione e 
		//un interno non avrebbe abbbastanza spazio per contenerli
		long tmp1 = 0;
		long tmp2 = 1;
		long numero = 0;
		
		System.out.println("Numero: " + tmp1);
		System.out.println("Numero: " + tmp2);
		
		for(int i = 0; i < 48; i++) {
			numero = tmp1 + tmp2;
			tmp1 = tmp2;
			tmp2 = numero;
			System.out.println("Numero: " + numero);
		}
	}
	
	static void esercizio4() {
		int [][] matrice = new int[4][3];
		int [][] trasposta = new int[3][4];
		
		//inizializzo matrice
		for(int i = 0; i < matrice.length; i++) { 
			for(int j = 0; j < matrice[0].length; j++) {
				matrice[i][j] = (int)(Math.random()*10);// riempio matrice con numeri casuali
			}
		}
		
		// trasposizione
		for(int i = 0; i < matrice.length; i++) { // scorro le righe di matrice (colonne di trasposta)
			for(int j = 0; j < matrice[0].length; j++) { // scorro le colonne di matrice (righe di trasposta)
				trasposta[j][i] = matrice[i][j];
			}
		}
		
		
		// stampo matrice
		System.out.println("Stampo Matrice: ");
		for(int i = 0; i < matrice.length; i++) { 
			for(int j = 0; j < matrice[0].length; j++) {
				System.out.print(matrice[i][j] + " ");
			}
			System.out.println("");
		}
		
		
		// stampo trasposta
		System.out.println("Stampo Trasposta: ");
		for(int i = 0; i < trasposta.length; i++) { 
			for(int j = 0; j < trasposta[0].length; j++) {
				System.out.print(trasposta[i][j]+ " ");
			}
			System.out.println("");
		}
	}
	
	
	
	public static void main(String[] args) {
		//esercizio1();
		
		System.out.println("Palindorma i topi non avevano nipoti: " + esercizio2_palindroma("i topi non avevano nipoti"));
		System.out.println("Palindorma anna: " + esercizio2_palindroma("anna"));
		System.out.println("Palindorma fuoco: " + esercizio2_palindroma("fuoco"));
		
		esercizio3();
		
		esercizio4();
	}

}
