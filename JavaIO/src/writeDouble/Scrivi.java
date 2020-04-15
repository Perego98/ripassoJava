package writeDouble;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Scrivi {

	public static void main(String[] args) {
		DataOutputStream out = null;
		DataInputStream in = null;
		
		FileOutputStream fout = null;
		FileInputStream fin = null;
		
		try {
			// creo in e out
			fout = new FileOutputStream("double.txt");
			out = new DataOutputStream(fout);// creerà il file se non presente
			
			fin = new FileInputStream("double.txt");
			in = new DataInputStream(fin);
			
			// scrivo un double su file
			out.writeDouble(5.78972984);
			out.flush();
			
			// lo leggo e lo stampo
			System.out.println("Double letto: " + in.readDouble());
			
			// chiudo
			fout.close();
			out.close();
			fin.close();
			in.close();

		} catch (FileNotFoundException e) {
			System.out.println("Eccezoine: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Eccezoine: " + e.getMessage());
		}
		
		
		
		

	}

}
