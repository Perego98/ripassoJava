package serverDiBenvenuto;

import java.net.*;
import java.util.Scanner;
import java.io.*;


public class Client {
	public static void main(String[] argv) {
		try{
			// screo oggetti
			Scanner input = new Scanner(System.in);
			Socket sock = new Socket("localhost",5200);
			PrintWriter out = new PrintWriter(sock.getOutputStream(),true);   
			InputStream s = sock.getInputStream();
		    BufferedReader recive = new BufferedReader(new InputStreamReader(s));
			String userInput = null;
			String line = null; 
			
			// leggo il nome
			System.out.print("Inserire nome: ");
			userInput = input.nextLine();
			
			// lo invio
			out.println(userInput);
			
		    // ricevo la risposta e la stampo
	   	    while ((line = recive.readLine()) != null) 						
	   	    	System.out.println(line);

	   	    // chiudo tutto
	   	    s.close();
		   	recive.close();
			out.close();
			sock.close();
			
		}catch(IOException e){ 
			System.out.println(e.getMessage()); 
		}
		
	}

}
