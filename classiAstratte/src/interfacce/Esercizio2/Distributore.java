package interfacce.Esercizio2;

import java.util.Random;

public class Distributore implements Comparable<Distributore>, GestoreDistributore {

	private String citta;
	private String proprietario;
	private int capacita;
	private int benzinaAttuale;
	private float incassi;
	private float prezzoLitro;
	
	
	
	public Distributore(String citta, String proprietario, int capacita, int benzinaAttuale, float prezzoLitro) {
		this.citta = citta;
		this.proprietario = proprietario;
		this.capacita = capacita;
		this.incassi = 0;
		this.prezzoLitro = prezzoLitro;
		
		if(benzinaAttuale <= capacita && benzinaAttuale >= 0)
			this.benzinaAttuale = benzinaAttuale;
		else if(benzinaAttuale < 0) 
			this.benzinaAttuale = 0;
		else
			this.benzinaAttuale = capacita;
			
	}

	@Override
	public void erogaCarburante() {
		Random eroga = new Random();
		int erogazione = eroga.nextInt(benzinaAttuale+1);
		if(benzinaAttuale>0) {
			benzinaAttuale = benzinaAttuale-erogazione;
			incassi += erogazione * prezzoLitro;
		}
		else
			System.out.println("Serbatoio vuoto");
	}

	
	@Override
	public void aggiungiCarburante(int aggiunta) {
		if(aggiunta+benzinaAttuale < capacita)
			benzinaAttuale += aggiunta;
		else {
			benzinaAttuale = capacita;
			System.out.println("Non tutti i litri sono stati  inseriti");
		}
	}

	@Override
	public void erogaIncassi() {
		System.out.println("Incassi: " + incassi + "\nGli incassi ora saranno azzerati");
		incassi = 0;
	}

	@Override
	public boolean compareTo(Distributore o) {
		if(capacita == o.getCapacita())
			return true;
		return false;
	}

	@Override
	public int getCapacita() {
		return capacita;
	}

	@Override
	public String toString() {
		return "Distributore [citta=" + citta + ", proprietario=" + proprietario + ", capacita=" + capacita
				+ ", benzinaAttuale=" + benzinaAttuale + ", incassi=" + incassi + ", prezzoLitro=" + prezzoLitro + "]";
	}

	
}
