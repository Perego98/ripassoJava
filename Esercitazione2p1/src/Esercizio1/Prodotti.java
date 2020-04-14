package Esercizio1;

public class Prodotti {

	private int codice_barre;
	private String descrizione;
	private float prezzo_unitario;
	
	public Prodotti(int codice_barre, String descrizione, float prezzo_unitario) {
		this.codice_barre = codice_barre;
		this.descrizione = descrizione;
		this.prezzo_unitario = prezzo_unitario;
	}

	public int getCodice_barre() {
		return codice_barre;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public float getPrezzo_unitario() {
		return prezzo_unitario;
	}

	public void setPrezzo_unitario(float prezzo_unitario) {
		this.prezzo_unitario = prezzo_unitario;
	}
	
	public void applicaSconto() {
		prezzo_unitario =  (prezzo_unitario - (prezzo_unitario * 5)/100);
	}

	
	

	public boolean equals(Prodotti obj) {
		if(obj != null)
			if(obj.getCodice_barre() == getCodice_barre())
				return true;
		return false;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "codice_barre=" + codice_barre + ", descrizione=" + descrizione + ", prezzo_unitario="
				+ prezzo_unitario;
	}
	
	
	
}
