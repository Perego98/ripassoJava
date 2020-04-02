
import java.util.Scanner;

public class EsArray {

	static void stampaArray() {
		// primo array
				int[] primo_array = {1,3,5,7,9,23,54,18,54,26};
				
				System.out.println("Stampa primo array...");
				for(int i = 0, j=primo_array.length-1; i < primo_array.length/2; i++, j--){
					System.out.print(primo_array[i] + "\t" + primo_array[j] + "\t");
				}
				System.out.println("");
				
				//secondo array
				int[] secondo_array = new int[10];
				int pari = 0, dispari = 0;
				
				//inizializzo con numeri a caso
				for(int i=0; i<secondo_array.length; i++) {
					secondo_array[i] = (int)(Math.random()*10); // genero numeri casuali tra 1 e 10
				}
				
				// conto i numeri pari e quelli dispari
				for(int i=0; i<secondo_array.length; i++) {
					if(secondo_array[i]%2 == 0)
						pari++;
					else
						dispari++;
				}
				
				if(pari == dispari)
					System.out.println("Pari e dispari uguali");
				else
					System.out.println("Pari e dispari diversi");
				
				
				// terzo array
				// avrei potuto riusare secondo_array dato ceh avevo gia generato 10 numeri random
				int[] terzo_array = new int[10];
				boolean uguali = false;
				
				//inizializzo con numeri a caso
				for(int i=0; i<terzo_array.length; i++) {
					terzo_array[i] = (int)(Math.random()*10); // genero numeri casuali tra 1 e 10
				}
				
				for(int i = 0; i<terzo_array.length-3; i++) {
					if(terzo_array[i] == terzo_array[i+1] && terzo_array[i] == terzo_array[i+2])
						uguali = true;
				}
				
				if(uguali)
					System.out.println("Tre valori consecutivi uguali");
				else
					System.out.println("NO");
				
				//quarto array
				String[] str1 = {"nome", "casa", "finestra", "gioco", "mappamondo"};
				String[] str2 = {"cognome", "albergo", "porta", "gioco", "mappa"};
				boolean trovato = false;
				
				for(int i = 0; i < str1.length && !trovato; i++) {
					for(int j = 0; j < str2.length && !trovato; j++) {
						if(str1[i] == str2[j])
							trovato = true;
					}
				}
				
				if(trovato)
					System.out.println("OK");
				else
					System.out.println("KO");
		
	}
	
	static void stampaStringhe() {
		// stampa al contrario
		Scanner input_stringhe = new Scanner(System.in);
		
		System.out.print("Inserisci una stringa: ");
		String txt = input_stringhe.nextLine();
		
		for(int i = txt.length()-1; i >= 0; i--) {
			System.out.print(txt.charAt(i));
		}
		System.out.println("");
		
		// stampa vocali
		System.out.print("Inserisci una stringa: ");
		String txt2 = input_stringhe.nextLine();;
		
		for(int i = 0; i < txt2.length(); i++) {
			char lettera = txt2.charAt(i);
			switch(lettera) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u': {
				System.out.print(lettera);
				break;
			}
			default:
				break;
			}
		}
		System.out.println("");
		
		//lunghezza stringhe che iniziano con la lettera maiuscola
		String[] str = {"nome", "Casa", "finestra", "Gioco", "mappamondo", 
				"cognome", "Albergo", "Porta", "gioco", "mappa", ""};
		
		int conta = 0;
		
		for(int i = 0; i< str.length; i++) {
			if(str[i] != null){ // controllo che la stringa esista
					if(str[i].length() > 0) { // se non è la stringa vuota
						int cod = (int)str[i].charAt(0);// prendo il codice ascii della prima lettera
						if(cod >= 65 && cod <= 90 ) {// se la lettera è una lettera maiuscola
							conta += str[i].length(); // aggiungo la lunghezza della parola alla conta
						}
					}
			}
		}
		
		System.out.println("Numero lettere: " + conta);		
		
		// input_stringhe.close();
	}
	
	static void stampaCicli() {
		// primo es
		Scanner input_cicli = new Scanner(System.in);
		int numeri_inseriti = 0;
		boolean po_par = true;
		
		
		System.out.println("Inserisci 10 numeri: ");
		while(numeri_inseriti < 10) {
			int n = input_cicli.nextInt();
			numeri_inseriti++;
			if(n < 0 || n % 2 == 1)
				po_par = false;
		}
		
		
		if(po_par)
			System.out.println("Tutti positivi e pari");
		else
			System.out.println("NO");
		
		// secondo es
		numeri_inseriti = 0; // riutilizzo questa variabile per la lettura
		int num_div3 = 0;
		int somma_num_div3 = 0;
		
		System.out.println("Inserisci 7 numeri: ");
		while(numeri_inseriti < 7) {
			int n = input_cicli.nextInt();
			numeri_inseriti++;
			if(n % 3 == 0) {
				num_div3++;
				somma_num_div3 += n;
			}				
		}
		if(num_div3 != 0)
			System.out.println("Media: " + somma_num_div3 / num_div3);
		else
			System.out.println("Media: 0");
		
		// terzo es
		Scanner input2 = new Scanner(System.in);
		
		int num_cicli = 0; 
		int num_caratteri = 0;
		int num_caratteri_inseriti = 0;
		while(num_cicli < 5) {
			System.out.println("Quanti caratteri vuoi inserire: ");
			num_caratteri = input_cicli.nextInt();
			
			
			while(num_caratteri_inseriti < num_caratteri) {
				System.out.println("Input: ");
				String car = input2.nextLine();
				System.out.println("Carattere: " + car);
				num_caratteri_inseriti++;
			}
			num_cicli++;
			num_caratteri_inseriti = 0;
			num_caratteri = 0;
		}
	}
	
	public static void main(String[] args) {
		
		stampaArray();
		
		stampaStringhe();
		
		stampaCicli();
		

	}

}
