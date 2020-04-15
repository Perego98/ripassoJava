package stampaFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StampaFile {

	public static void main(String[] args) {
		
		FileReader file = null;
		BufferedReader in = null;
		try {
			// creo il buffer
			file = new FileReader("testo.txt");
			in = new BufferedReader(file);
			
			// lego una riga
			String line = in.readLine();
			while(line != null){ // fino a che ho ricghe leggo e stampo
				System.out.println(line);
				line = in.readLine();
			}
			
			// chiudo
			file.close();
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Eccezione: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Eccezione: " + e.getMessage());
		}	

	}

}
