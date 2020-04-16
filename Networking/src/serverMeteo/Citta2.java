package serverMeteo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Citta2 {
	public static void main(String[] argv){
		System.out.println("Citta2");
		try{

			// creo gli oggetti, client inizia la conversazione
			Scanner input = new Scanner(System.in);
			Socket sock = new Socket("localhost",5202);
			PrintWriter out = new PrintWriter(sock.getOutputStream(),true);   
			InputStream s = sock.getInputStream();
		    BufferedReader recive = new BufferedReader(new InputStreamReader(s));
			String userInput = "soleggiato\n";
			String msgRecive = null; 

			//System.out.print("Meteo Citta1 oggi: ");
			//userInput = input.nextLine();
			
			// lo invio
			out.println(userInput);

			// ricevo la risposta e la stampo
			System.out.println("Meteo altre citta:\n");
	   	    while ((msgRecive = recive.readLine()) != null) {
	   	    	if(msgRecive != null && !msgRecive.equals(""))
	   	    	System.out.println(msgRecive);
	   	    }
	   	    	

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
