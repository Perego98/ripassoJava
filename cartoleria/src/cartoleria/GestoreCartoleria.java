package cartoleria;

import java.util.Date;

public class GestoreCartoleria {
	
	private Cartoleria cartoleria;
	private Cliente [] clienti;
	private Ordine [] ordini;
	
	public GestoreCartoleria(int numero_clienti, int dimensione_magazzino, int numero_ordini) {
		this.cartoleria = new Cartoleria(dimensione_magazzino);
		clienti = new Cliente[numero_clienti];
		ordini = new Ordine[numero_ordini];
	}
	
	public void addCliente(Cliente cliente) {
		if(cliente != null) {
			for(int i = 0; i <clienti.length; i++)
				if(clienti[i] != null)
					clienti[i] = cliente;
		}
	}
	
	private Cliente getCliente(int id) {
		if(id >= 0 && id < clienti.length) {
			return clienti[id];
		}
		
		return null;
	}
	
	private Ordine getOrdine(int id) {
		if(id >= 0 && id < ordini.length) {
			return ordini[id];
		}
		
		return null;
	}
	
	public void aggiungiArticolo(Articolo articolo) {
		boolean inserito = true;
		inserito = cartoleria.add(articolo);
		if(!inserito) System.out.println("Il magazzino è pieno");
	}
		
	public void giacenze() {
		System.out.println("Stampo giacenze: ");
		cartoleria.stampaGiacenze();
	}	
	
	public void totaleGiacenze() {
		System.out.println("Valore totale giacenze: " + cartoleria.stampaValoreTotaleGiacenze());
	}
	
	
	public void creaOrdine(Date data, Cliente cliente, int numero_articoli) {
		if(cliente != null && data != null) {
			for(int i = 0; i< ordini.length; i++) {
				if(ordini[i] != null)
					ordini[i] = new Ordine(data, i, cliente, numero_articoli);
			}
		}
	}
	
	public void insArticolo(int id_articolo, int id_ordine) {
		boolean ordine_inserito = false;
		ordine_inserito = getOrdine(id_ordine).addArticolo(cartoleria.getArticolo(0));
		if(!ordine_inserito) System.out.println("Ordine non inserito");
		else cartoleria.eliminaArticoli(0);
	}
	
	public void totale_ordine(int id_ordine) {
		if(getOrdine(id_ordine) != null)
			System.out.println("Totale ordine: " + getOrdine(id_ordine).totale());
	}
	
	public void saldo_cliente(int id_cliente) {
		if(getCliente(id_cliente) != null)
			System.out.println("Saldo cliente: " + getCliente(id_cliente).getSaldo());
	}
	
	public void riepologo(int id_ordine) {
		if(getOrdine(id_ordine) != null) 
			getOrdine(id_ordine).riepilogo_ordine();
	}
	
	public void chiudiOrdine(int id_ordine) {
		if(getOrdine(id_ordine) != null) {
			boolean ordine_chiuso = getOrdine(id_ordine).chiudiOrdine();
			System.out.println("Ordine chiuso: " + ordine_chiuso);
			
			// se l'ordine va a buon fine mi faccio restituire l'elenco degli
			// articoli ordinati e li tolgo dal magazzino
			if(ordine_chiuso) {
				cartoleria.eliminaArticoli(getOrdine(id_ordine).elencoArticoli());
			}
			else {
				cartoleria.addArticoli(getOrdine(id_ordine).elencoArticoli());
				System.out.println("Ordine non andato a buon fine");
			}
		}
		
	}
	
	
	
}
