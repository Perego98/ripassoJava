package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Server {
	public static void main(String[] argv){
		boolean ripeti = true;
		try{
			System.out.println("Chat Server");
			
			 ServerSocket acceptSocket = new ServerSocket(5200); 
			 while(ripeti)
	  		 {
				
			    // attesa di una richiesta di connessione	
			    Socket clientSock=acceptSocket.accept(); 
			    Scanner read = new Scanner(System.in);
			    InputStream s = clientSock.getInputStream();
			    BufferedReader input = new BufferedReader(new InputStreamReader(s));
			    PrintWriter out = new PrintWriter(clientSock.getOutputStream(),true); 
			    String msgRecive = input.readLine();
			    String userInput = null;
			    System.out.println("Other: " + msgRecive);
			    
		    	 // se ricevo stop spengo il server
			    if(msgRecive.equals("stop"))
			    	ripeti = false;

			    // eseguo solo se non devo uscire
			    if(ripeti) {
				    // Scrivo il messaggio
					System.out.print("youS: ");
					userInput = read.nextLine();
					// se scrivo stop spengo il server
				    if(userInput.equals("stop"))
				    	ripeti = false;
	
			   	    // lo invio 
			   	    out.println(userInput);
			    }
				    

		   	    // chiudo tutto
		   	    out.close();
			    input.close();  
			    s.close();        
			    clientSock.close();
			   }
		}catch(IOException e){ 
			 System.out.println(e.getMessage()); 
		 }
	}
}
