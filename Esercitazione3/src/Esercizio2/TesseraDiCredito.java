package Esercizio2;

public class TesseraDiCredito {

	private int codice;
	private float credito;
	
	public TesseraDiCredito(int codice) {
		this.codice = codice;
		this.credito = 0;
	}

	public int getCodice() {
		return codice;
	}

	public float getCredito() {
		return credito;
	}

	public void setCredito(float credito) {
		this.credito = credito;
	}

	@Override
	public String toString() {
		return "TesseraDiCredito: codice=" + codice + ", credito=" + credito;
	}
	
	
	
	
	
}
