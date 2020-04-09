package interfacce.Esercizio3;

public abstract class StampaOperazione {

	private float risultato;
	
	public void stampaRisultato() {
		System.out.println("Risultato: " + risultato);
	}

	public void setRisultato(float risultato) {
		this.risultato = risultato;
	}
	
	
}
