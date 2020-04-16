package serverDiBenvenuto;

import java.net.*;
import java.util.Date;
import java.io.*;


public class Server {
	public static void main(String[] argv){
		int numero = 0;  
		boolean ripeti = true;
		try{
			 ServerSocket acceptSocket = new ServerSocket(5200);
			 while(ripeti)
	  		 {
			    // attesa di una richiesta di connessione
			    Socket clientSock=acceptSocket.accept(); 
			    InputStream s = clientSock.getInputStream();
			    BufferedReader input = new BufferedReader(new InputStreamReader(s));
			    String nome = input.readLine();
			    
			    // se ricevo stop spengo il server
			    if(nome.equals("stop")) {
			    	ripeti = false;
				    input.close();  
				    s.close();        
				    clientSock.close();
			    }else {
			    	
				    Date oggi = new Date();
				    numero++;
				    
				    // creo il messaggio di ritorno
				    String risposta = "Benvenuto " + nome + ", Time: " + oggi.toString() + ",\nSei il visistatore"
				    		+ " numero " + numero;	
				    // lo stampo su server per conferma
			   	    System.out.println("Invio messaggio.. msg text: " + risposta);
			   	    
			   	    // lo invio
			   	    PrintWriter out = new PrintWriter(clientSock.getOutputStream(),true);  
			   	    out.println(risposta);
			   	    
			   	    // chiudo tutto
			   	    out.close();
				    input.close();  
				    s.close();        
				    clientSock.close();
			    }
	       	}
		 }catch(IOException e){ 
			 System.out.println(e.getMessage()); 
		 }
	}
}
