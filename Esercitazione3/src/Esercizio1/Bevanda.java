package Esercizio1;

public class Bevanda {
	private String codice; // maiuscolo o minuscolo sono considerati lo stesso codice
	private String nome;
	private float prezzo;
	
	public Bevanda(String codice, String nome, float prezzo) {
		this.codice = codice;
		this.nome = nome;
		this.prezzo = prezzo;
	}

	public String getCodice() {
		return codice;
	}

	public String getNome() {
		return nome;
	}

	public float getPrezzo() {
		return prezzo;
	}
	

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "Bevanda: codice=" + codice + ", nome=" + nome + ", prezzo=" + prezzo;
	}

	
	
	
	
}
