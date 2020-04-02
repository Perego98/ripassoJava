package cartoleria;

import java.util.Date;

public class Ordine {

	private Date data;
	private int numero;
	private Cliente cliente;
	private Articolo [] articoli;
	
	public Ordine(Date data, int numero, Cliente cliente, int numero_articoli) {
		this.data = data;
		this.numero = numero;
		this.cliente = cliente;
		this.articoli = new Articolo[numero_articoli];
	}

	
	public boolean addArticolo(Articolo articolo) {
		boolean inserito = false;
		if(articolo != null) {// se l'articolo esiste
			if(!find(articolo)) {// se l'articolo non è gia stato inserito
				for(int i = 0; i < articoli.length && !inserito; i++) {
					if(articoli[i] == null) { // appena trova uno spazio vuoto lo inserisce
						articoli[i] = articolo;
						inserito = true;
					}
				}
			}
		}
		return inserito;
	}
	
	public float totale() {
		float totale = 0;
			for(int i = 0; i < articoli.length; i++) {
				if(articoli[i] != null) 
					totale += articoli[i].getPrezzoVendita();
			}
		return totale;
	}
	
	public boolean chiudiOrdine() {
		// se il cliente è un privato
		if(cliente != null) {
			if(cliente.getClass() != new Azienda().getClass()) {
				if(totale() > cliente.getSaldo()) {
					System.out.println("Saldo non sufficente, Totale: " + totale() + 
										" Saldo disponibile: " + cliente.getSaldo());
					return false;
				}
			}
		}
		else {
			System.out.println("Il cliente non esiste");
			return false;
		}
		
		cliente.setSaldo( cliente.getSaldo() - totale());
		
		return true;
		
	}
	
	public Articolo [] elencoArticoli() {
		return articoli;		
	}
	
	
	public void riepilogo_ordine() {
		for(int i = 0; i < articoli.length ; i++) {
			if(articoli[i] != null) {
				System.out.println("Articolo ordine: " + articoli[i].toString());
			}
		}		
	}
	
	
	private boolean find(Articolo articolo) {
		boolean trovato = false;
		for (int i = 0; i < articoli.length; i++) {
			if(articoli[i] != null) {
				if(articoli[i].getId() == articolo.getId())
					trovato = true;
			}
		}
		
		return trovato;
	}
	
	
	public void eliminaArticoli(int id) {
		if(id >= 0 && id < articoli.length)
			articoli[id] = null;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	

	
	
}
