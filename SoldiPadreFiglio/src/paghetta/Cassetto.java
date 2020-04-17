package paghetta;

public class Cassetto {

	private float soldiContenuti;
	private boolean cassettoPieno;

	
	public Cassetto() {
		this.soldiContenuti = 0;
		this.cassettoPieno = false;
	}
	
	synchronized void inserisciSoldi(float soldi) {
		while(cassettoPieno == true) // se il cassetto è pieno
			try {
				wait(); // attendo che si svuoti
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		soldiContenuti = soldi;
		cassettoPieno = true;
		notifyAll();// sveglio tutti
		System.out.println("*Cassetto* Soldi inseriti: " + soldi);
	} 
	
	synchronized float prelevaSoldi() {
		System.out.println("*Cassetto* Soldi prelevati: " + soldiContenuti);
		while(cassettoPieno == false) // se il cassetto è vuoto
			try {
				wait(); // attendo che si riempia
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		cassettoPieno = false;
		notifyAll();
		return soldiContenuti;
	}

	public boolean isCassettoPieno() {
		return cassettoPieno;
	} 
	
	

}
