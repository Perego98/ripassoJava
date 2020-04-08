package interfacce.Esercizio2;

public class Distributore implements Comparable<Distributore>, GestoreDistributore {

	private String citta;
	private String proprietario;
	private int capacita;
	private float benzinaAttuale;
	
	
	
	public Distributore(String citta, String proprietario, int capacita, float benzinaAttuale) {
		this.citta = citta;
		this.proprietario = proprietario;
		this.capacita = capacita;
		
		if(benzinaAttuale <= capacita && benzinaAttuale >= 0)
			this.benzinaAttuale = benzinaAttuale;
		else if(benzinaAttuale < 0) 
			this.benzinaAttuale = 0;
		else
			this.benzinaAttuale = capacita;
			
	}

	@Override
	public void erogaCarburante() {
		
	}

	@Override
	public void aggiungiCarburante() {
		// TODO Auto-generated method stub

	}

	@Override
	public void erogaIncassi() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean compareTo(Distributore o) {
		// TODO Auto-generated method stub
		return false;
	}

}
