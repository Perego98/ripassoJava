package paghetta;


public class Figlio extends Thread{

	private String nome;
	private float TotalesoldiGuadagnati;
	private float soldiGuadagnati;
	private Cassetto cassetto;
	
	public Figlio(String nome, Cassetto cassetto) {
		this.nome = nome;
		this.soldiGuadagnati = 0;
		this.TotalesoldiGuadagnati = 0;
		this.cassetto = cassetto;
	}

	
	@Override
	public void run() {
		while(true){
			// se il cassetto è pieno ritiro i soldi
			if(cassetto.isCassettoPieno()) {
				soldiGuadagnati = cassetto.prelevaSoldi();	
				TotalesoldiGuadagnati += soldiGuadagnati;
				System.out.println("*Figlio " + nome + "* Soldi prelevati dal figlio " + soldiGuadagnati 
					+ "\nTotale: " + TotalesoldiGuadagnati);
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

	
	
	
}
