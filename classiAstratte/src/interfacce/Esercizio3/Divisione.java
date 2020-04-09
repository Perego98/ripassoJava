package interfacce.Esercizio3;

public class Divisione extends StampaOperazione implements Operazione {

	private float a;
	private float b;
	
	public Divisione(float a, float b) {
		this.a = a;
		this.b = b;
	}

	public void calcolaOperazione() {
		setRisultato(a / b);
	}
}
