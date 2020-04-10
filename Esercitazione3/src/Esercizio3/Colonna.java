package Esercizio3;

import Esercizio1.Bevanda;

public class Colonna {

	private int numeroColonna;
	private Bevanda bevanda;
	private int numeroLattine;
	
	public Colonna() {
		this.numeroColonna = 0;
		this.bevanda = null;
		this.numeroLattine = 0;
	}
	
	public void aggiornaColonnaC(int numeroColonna, Bevanda bevanda, int numeroLattine){
		this.numeroColonna = numeroColonna;
		this.bevanda = bevanda;
		if(numeroLattine >= 0)
			this.numeroLattine = numeroLattine;
		else {
			System.out.println("Numero lattine deve essere positivo... impostato a 0");
			this.numeroLattine = 0;
		}
	}

	public boolean decrementa(int dec) {
		if(dec <= numeroLattine) {
			numeroLattine -= dec;
			return true;
		}
		return false;

	}
	
	private Bevanda getBevanda() {
		return bevanda;
	}

	public float getPrezzoBevandaC() {
		return getBevanda().getPrezzo();
	}
	
	public String getCodeBevanda() {
		return getBevanda().getCodice();
	}
	
	public int lattineDisponibili() {
		return numeroLattine;
	}

	@Override
	public String toString() {
		return "Colonna: numeroColonna=" + numeroColonna + ", " + bevanda.toString() + ", numeroLattine=" + numeroLattine;
	}

	
	
}
