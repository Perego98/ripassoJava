package serverMeteo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
// le città devono collegarsi in ordine 1, 2, 3, 4, 5
	public static void main(String[] argv){

		String [] meteo = new String[5];
		int portStart = 5201;
		try{
			System.out.println("*Server Meteo*");
			
			ServerSocket[] acceptSocket = new ServerSocket[5];
			Socket[] clientSock = new Socket[5];
			InputStream[] s = new InputStream[5];
			BufferedReader[] input = new  BufferedReader[5];
			PrintWriter[] out = new PrintWriter[5];
			
			
			for(int i = 0; i < 5; i++) {
				acceptSocket[i] = new ServerSocket(portStart+i);
				clientSock[i] = acceptSocket[i].accept();
				s[i] = clientSock[i].getInputStream();
				input[i] = new BufferedReader(new InputStreamReader(s[i]));
				
				// salvo i dati
				 meteo[i] = input[i].readLine();
				
			}
			
			// una volta presi tutti i dati li rimando
			for(int i = 0; i < 5; i++) {
				out[i] = new PrintWriter(clientSock[i].getOutputStream(),true);
				String msg = "";
				for(int j = 0; j < 5; j++) {
					if(i!=j) {
						msg += "Citta" + (j+1) + " meteo: " + meteo[j] + "\n";
					}					 
				}
				out[i].println(msg);
			}
			
			 // chiudo tutto
			for(int i = 0; i < 5; i++) {
				acceptSocket[i].close();
				clientSock[i].close();
				out[i].close();
			    input[i].close();  
			    s[i].close();
			}
			
   
		}catch(IOException e){ 
			 System.out.println(e.getMessage()); 
		 }
	}
}
