package scriviImpiegati;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class testSave {

	public static void main(String[] args) {

		// creo gli impiegati
		String nomeFile = "Impiegati.txt";
		Employee imp1 = new Employee("Cognome", "Nome", 2000, 2000);
		Employee imp2 = new Employee("faq", "gino", 2007, 200);
		Employee imp3 = new Employee("faaaaf", "matteo", 2008, 1000);
		
		FileOutputStream fout;
		ObjectOutputStream out;
		FileInputStream fin;
		ObjectInputStream in;
		try {
			// creo in e out
			fout = new FileOutputStream(nomeFile);
			out = new ObjectOutputStream(fout);
			fin = new FileInputStream(nomeFile);
			in = new ObjectInputStream(fin);
			
			// scrivo
			out.writeObject(imp1);
			out.writeObject(imp2);
			out.writeObject(imp3);
			
			
			// li stampo
			Employee impTemp = (Employee) in.readObject();
			System.out.println(impTemp.toString());
			
			impTemp = (Employee) in.readObject();
			System.out.println(impTemp.toString());
			
			impTemp = (Employee) in.readObject();
			System.out.println(impTemp.toString());
			
			// chiudo
			fin.close();
			fout.close();
			in.close();
			out.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Eccezione File non trovato: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Eccezione IO Exception: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Eccezione Classe non trovata: " + e.getMessage());
		}

		

		
		

		
		
		
		
	}

}
