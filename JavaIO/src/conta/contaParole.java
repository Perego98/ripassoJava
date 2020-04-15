package conta;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;



public class contaParole {

	public static void main(String[] args) {
		HashMap<String, Integer> contaParole = new HashMap<String, Integer>();
		boolean presente = false;
		FileReader file = null;
		String fileName = "testo2.txt";
		
		
		
		
		// leggo il file con lo split lo spazio
		
		try {
			file = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			System.out.println("Eccezione: " + e.getMessage());
		}
		Scanner sc = new Scanner(file);
		sc = sc.useDelimiter("[ .,:;!?~()-]+");
		
		while(sc.hasNext()){
			String ss = (String)sc.next();
			int numero = 1;
			
			// inserisco in una hashList con chiave la parola stessa e il numero a destra
			for(String key : contaParole.keySet()) {
				if(key.equalsIgnoreCase(ss)) {
					presente = true;
					numero = contaParole.get(ss);
					// se lo ho trovato esco
					break;
				}
			}
			
			// se non è gia stato usato lo inserisco
			if(!presente)
				contaParole.put(ss, numero);
			else
				contaParole.replace(ss, numero+1);
			
			presente = false;
			
		} 

		// stampo valori
		for(String key : contaParole.keySet()) {
			System.out.println(key + " " + contaParole.get(key));			
		}

	}
}
