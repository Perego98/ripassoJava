
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
	
	public static void main(String[] args) {
		
		esercizio1();
		
		System.out.println("Palindorma i topi non avevano nipoti: " + esercizio2_palindroma("i topi non avevano nipoti"));
		System.out.println("Palindorma anna: " + esercizio2_palindroma("anna"));
		System.out.println("Palindorma fuoco: " + esercizio2_palindroma("fuoco"));
		
		
	}

}
