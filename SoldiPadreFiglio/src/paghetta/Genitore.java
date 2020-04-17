package paghetta;

import java.util.Random;

public class Genitore extends Thread{

	private String nome;
	private Cassetto cassetto;
	
	public Genitore(String nome, Cassetto cassetto) {
		super();
		this.nome = nome;
		this.cassetto = cassetto;
	}

	@Override
	public void run() {
		
		while(true){
			// se il cassetto è vuoto inserisco dei soldi
			if(!cassetto.isCassettoPieno()) {
				Random random = new Random();
				float soldi = (float) random.nextInt(100);
				System.out.println("*Genitore* Cassetto riempito con: " + soldi);
				cassetto.inserisciSoldi(soldi);
			}
			// attendo 700 millisecondi
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private String getNome() {
		return nome;
	}


	private void setNome(String nome) {
		this.nome = nome;
	}

	
	
}
