package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	public static void main(String[] argv) {
		boolean ripeti = true;
		System.out.println("Chat Client");
		try{
			while(ripeti) {
			// creo gli oggetti, client inizia la conversazione
			Scanner input = new Scanner(System.in);
			Socket sock = new Socket("localhost",5200);
			PrintWriter out = new PrintWriter(sock.getOutputStream(),true);   
			InputStream s = sock.getInputStream();
		    BufferedReader recive = new BufferedReader(new InputStreamReader(s));
			String userInput = null;
			String msgRecive = null; 
			
				// se non ho ancora ricevuto lo stop
				if(ripeti) {
					// Scrivo il messaggio
					System.out.print("youC: ");
					userInput = input.nextLine();
					// lo invio
					out.println(userInput);
					if(userInput.equals("stop")) {
						ripeti = false;
					}
			
					// ricevo la risposta e la stampo
			   	    while ((msgRecive = recive.readLine()) != null) {
			   	    	System.out.println("Other: " + msgRecive);
			   	    	if(msgRecive !=null)
			   	    	if(msgRecive.equals("stop")) {
							ripeti = false;
						}
			   	    } 								
				}

	   	    // chiudo tutto
	   	    s.close();
		   	recive.close();
			out.close();
			sock.close();
			
			}			
		}catch(IOException e){ 
			System.out.println(e.getMessage()); 
		}
	}
}
