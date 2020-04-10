package esercizio4;

import Esercizio1.Bevanda;
import Esercizio1.BevandaNonValida;
import Esercizio2.GestoreCarte;
import Esercizio2.TesseraNonValida;
import Esercizio3.Distributore;

public class Erogazione {

	private Distributore dist;
	private GestoreCarte gestoreCard;

	
	public Erogazione() {
		this.dist = new Distributore();
		this.gestoreCard = new GestoreCarte();
		rimpiCarte();
		riempiDistributore();
	}
	
	private void rimpiCarte() {
		gestoreCard.addCarta(1);
		gestoreCard.addCarta(2);
		gestoreCard.addCarta(3);
		
		try {
			gestoreCard.caricaTessera(1, 67.78f);
			gestoreCard.caricaTessera(2, 7.78f);
			gestoreCard.caricaTessera(3, 6.78f);
		} catch (TesseraNonValida e) {
			System.out.println(e.getMessage());
		}
		

	}
	
	private void riempiDistributore() {
		dist.aggiornaColonna(1, new Bevanda("A", "Acqua", 0.10f), 40);
		dist.aggiornaColonna(2, new Bevanda("C", "CocaCola", 0.50f), 1);
		dist.aggiornaColonna(3, new Bevanda("B", "Birra", 2.50f), 50);
		dist.aggiornaColonna(4, new Bevanda("A", "Acqua", 0.10f), 50);
	}
	
	public int eroga(String codBevanda, int CodTessera) throws TesseraNonValida, BevandaNonValida, BevandaEsaurita, CreditoInsufficiente {

		int colonna = -1;// se riscontro problemi ritorno -1
		// verifico che i codici siano validi
		if(dist.exist(codBevanda)) {
			if(gestoreCard.exist(CodTessera)) {
			// verifico che ci sia abbastanza credito residuo
			if(dist.getPrezzoBevanda(codBevanda) <= gestoreCard.leggiCredito(CodTessera)) {
				// controllo che siano disponibili lattine
				if(dist.lattineDisponibili(codBevanda) > 0) {
					colonna = dist.colonnaLattina(codBevanda);
					boolean erog = dist.eroga(colonna);
					if(erog)
						gestoreCard.scalaCredito(CodTessera, dist.getPrezzoBevanda(codBevanda));
					else
						System.out.println("Erogazione in Erogazione fallita");
				}
				else {
					throw new BevandaEsaurita("Eccezione lattine non disponibili");
				}
			}
			else {
				throw new CreditoInsufficiente("Eccezione credino inferiore al prezzo della lattina");
			}
		}
		else {
			throw new TesseraNonValida("Eccezione il codice della carta inserito non è valido");
		}
	}
	else {
		throw new BevandaNonValida("Eccezione il codice bevanda inserito non è valido");
	}

		
		
		return colonna;
	}

	@Override
	public String toString() {
		return "Erogazione\n" + dist.toString() + gestoreCard.toString();
	}
	
	
	
	
}
