package copiaIncolla;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopiaIncolla {

	public static void main(String[] args) {
	

		
		try {
			 // creo i file e i buffer di in e di out
			 FileInputStream sourceStream = new FileInputStream("prova.jpg");
			 BufferedInputStream sourceBufferStream = new BufferedInputStream(sourceStream);
			 FileOutputStream destStream = new FileOutputStream("prova copia.jpg");
			 BufferedOutputStream destBufferStream = new BufferedOutputStream(destStream);
			 
			// vreo un array di bytes da 1024
				byte[] bytes = new byte[1024];
				int bytesRead=0;
				try {
					// leggo
					while ((bytesRead=sourceBufferStream.read(bytes)) != -1) {
						// e scrivo
						destBufferStream.write(bytes,0,bytesRead);
					}
			} catch (IOException e) {
				System.out.println("Eccezione: " + e.getMessage());
			}
			
			try {
				// chiudo
				sourceBufferStream.close();
				destBufferStream.close();
				destStream.close();
				sourceStream.close();
			} catch (IOException e) {
				System.out.println("Eccezione: " + e.getMessage());
			}
			

			
		} catch (FileNotFoundException e) {
			System.out.println("Eccezione: " + e.getMessage());
		}
		

		
		
		
	}

}
