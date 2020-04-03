package cartoleria;

import java.util.Date;

public class main {

	static void add(Cartoleria cartoleria, Articolo articolo) {
		boolean inserito = true;
		inserito = cartoleria.add(articolo);
		if(!inserito) System.out.println("Il magazzino è pieno");
	}
	
	static void riempiMagazzino(Cartoleria cartoleria) {
		
		add(cartoleria, new Gomma("Mini", "Faber-Castel", 3, new Dimensione(5, 2, 3), "Parallelepipedo"));
		add(cartoleria, new Penna("Bic", "Stilo", 2, "Nero"));
		add(cartoleria, new Gomma("Normale", "Faber-Castel", 6, new Dimensione(5, 5, 8), "Parallelepipedo"));
		add(cartoleria, new Gomma("Normale", "Bic", 3, new Dimensione(5, 5, 3), "Trapezio"));
		add(cartoleria, new Gomma("Mini", "Faber-Castel", 3, new Dimensione(5, 2, 3), "Parallelepipedo"));
		add(cartoleria, new Gomma("Mini", "Faber-Castel", 3, new Dimensione(5, 2, 3), "Parallelepipedo"));
		add(cartoleria, new Penna("Bic", "Stilo", 2, "Blu"));
		add(cartoleria, new Penna("Bic", "Sfera", 5, "Verde"));
		add(cartoleria, new Penna("Bic", "Stilo", 3, "Nera"));
		add(cartoleria, new Penna("Bic", "Stilo", 4, "Rossa"));
		
	}
	
	static void riepilogo(Cartoleria cartoleria) {
		System.out.println("Stampo giacenze: ");
		cartoleria.stampaGiacenze();
		System.out.println("Valore totale giacenze: " + cartoleria.stampaValoreTotaleGiacenze());
	}
	
	static void insArticolo(Ordine ordine, Cartoleria cartoleria, int id_articolo) {
		
		// se riesco ad inserire un articolo nell'ordine lo elimino dal magazzino
		// per impedire che un secondo cliente possa ordinare lo stesso articolo gia 
		// prenotato
		boolean ordine_inserito = false;
		ordine_inserito = ordine.addArticolo(cartoleria.getArticolo(id_articolo));
		if(!ordine_inserito) System.out.println("Ordine non inserito");
		else cartoleria.eliminaArticoli(id_articolo);

		
	}
	
	static void riepilogoOrdine(Ordine ordine, Cliente cliente) {
		System.out.println("Totale ordine: " + ordine.totale());
		System.out.println("Saldo cliente: " + cliente.getSaldo());
		ordine.riepilogo_ordine();
	}
	
	static void chiudiOrdine(Ordine ordine, Cartoleria cartoleria) {
		boolean ordine_chiuso = ordine.chiudiOrdine();
		//System.out.println("Ordine chiuso: " + ordine_chiuso);
				
		// se l'ordine va a buon fine stampo a video "ordine chiuso"
		// se non va a buon fine mi faccio restituire l'elenco degli
		// articoli ordinati e li rimetto in magazzino
		if(ordine_chiuso) {
			System.out.println("Ordine chiuso");
			cartoleria.eliminaArticoli(ordine.elencoArticoli());
		}
		else { 
			cartoleria.addArticoli(ordine.elencoArticoli());
			System.out.println("Ordine non andato a buon fine");
		}
	}
	
	public static void main(String[] args) {		
		
			
		// creo una cartoleria con spazio per 10 articoli
		Cartoleria smile = new Cartoleria(10);
		
		// la riempio
		riempiMagazzino(smile);
			
		//stampo gicaenze e loro valore
		riepilogo(smile);
		
		// creo sei clienti
		Cliente [] clienti = new Cliente[6];
		clienti[0] = new Privato("Davide");
		clienti[1] = new Privato("Golia", 1);
		clienti[2] = new Azienda("Alluminox");
		clienti[3] = new Azienda("Esselunga", 300);
		clienti[4] = new Azienda("Conad", 300);
		clienti[5] = new Azienda("Gigante", 300);
		
		Date oggi = new Date(10, 2, 2020);
		
		//!!! PRIMO ORDINE
		// creo un ordine
		Ordine ord1 = new Ordine(oggi, 1, clienti[0], 2);
		
		// inserisco gli articoli nell'ordine
		insArticolo(ord1, smile, 0);
		insArticolo(ord1, smile, 1);
		insArticolo(ord1, smile, 1);
		
		
		riepilogoOrdine(ord1, clienti[0]);
		
		chiudiOrdine(ord1, smile);
				
		
		//!!! FINE PRIMO ORDINE
		
		// ricontrollo le giacenze
		System.out.println("Stampo giacenze: ");
		smile.stampaGiacenze();
		
		
		
		// reinserisco un articolo per controllare che venga messo nella prima posizione
		add(smile, new Penna("Bic", "Stilo", 1, "Blu"));
		
		System.out.println("Stampo giacenze: ");
		smile.stampaGiacenze();
		
		
		//!!! SECONDO ORDINE
		Ordine ord2 = new Ordine(oggi, 2, clienti[1], 3);
		
		// inserisco gli articoli nell'ordine
		insArticolo(ord2, smile, 0);
		insArticolo(ord2, smile, 3);
		insArticolo(ord2, smile, 1);
		
		riepilogoOrdine(ord2, clienti[1]);
		
		// chiudo l'ordine con ancora uno spazio nel carrello vuoto
		chiudiOrdine(ord2 , smile);
		
		
		//!!! FINE SECONDO ORDINE
		
		//!!! TERZO ORDINE
		// effetto gli altri ordini
		Ordine ord3 = new Ordine(oggi, 2, clienti[2], 10);
		
		// inserisco gli articoli nell'ordine
		insArticolo(ord3, smile, 0);
		insArticolo(ord3, smile, 2);
		insArticolo(ord3, smile, 7);
		insArticolo(ord3, smile, 9);
		
		
		// chiudo l'ordine con ancora spazio nel carrello vuoto
		riepilogoOrdine(ord3, clienti[2]);

		// chiudo l'ordine
		chiudiOrdine(ord3 , smile);
		
		//!!! FINE TERZO ORDINE
		
		// ricontrollo le giacenze
		System.out.println("Stampo giacenze: ");
		smile.stampaGiacenze();
		
		//!!! QUARTO ORDINE
		// effetto gli altri ordini
		Ordine ord4 = new Ordine(oggi, 2, clienti[3], 10);
		
		// inserisco gli articoli nell'ordine
		insArticolo(ord4, smile, 3);
		insArticolo(ord4, smile, 4);
		insArticolo(ord4, smile, 5);
		insArticolo(ord4, smile, 6);
		insArticolo(ord4, smile, 8);
		
		riepilogoOrdine(ord4, clienti[3]);
		
		// chiudo l'ordine
		chiudiOrdine(ord4 , smile);
		
		//!!! FINE QUARTO ORDINE
		
		// ricontrollo le giacenze
		// ora il magazzino è vuoto
		System.out.println("Stampo giacenze: ");
		smile.stampaGiacenze();
		
		System.out.println("**TEST CHIUSURA ORDINE CONCORRENTE**");
		//!!! Testo cosa accade quando creo due ordini contemporaneamente
		// che hanno al loro interno alcuni oggetti in comune
		// e il primo viene chiuso prima del secondo
		
		add(smile, new Penna("Pentel", "Sfera", 3, "Nera"));
		add(smile, new Penna("Bic", "Stilo", 1, "Blu"));
		add(smile, new Penna("Uni-Ball", "Sfera", 5, "Arancio"));
		
		Ordine od1 = new Ordine(oggi, 2, clienti[4], 10);
		Ordine od2 = new Ordine(oggi, 2, clienti[5], 10);
		
		// aggiungo l'articolo 0 ad entrambi
		insArticolo(od1, smile, 0);
		insArticolo(od2, smile, 0);
		insArticolo(od1, smile, 1);
		insArticolo(od2, smile, 2);
		
		
		// riepilogo
		riepilogoOrdine(od1, clienti[4]);
		riepilogoOrdine(od2, clienti[5]);
		
		// chiudo od1
		chiudiOrdine(od1 , smile);
		
		
		// chiudo od2
		chiudiOrdine(od2 , smile);
		
		// controllo il saldo dei clienti dopo il pagamento
		System.out.println("Saldo cliente: " + clienti[4].getSaldo());
		System.out.println("Saldo cliente: " + clienti[5].getSaldo());
	
	}

}
