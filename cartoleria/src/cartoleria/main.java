package cartoleria;

import java.util.Date;

public class main {

	public static void main(String[] args) {
		int num_clienti = 10, dimensione_magazzino = 10, numero_ordini = 6;
		Date oggi = new Date(10, 2, 2020);
		
		GestoreCartoleria gestore = new GestoreCartoleria(num_clienti, dimensione_magazzino, numero_ordini);
		
		// riempio la cartoleria
		gestore.aggiungiArticolo(new Gomma("Mini", "Faber-Castel", 3, new Dimensione(5, 2, 3), "Parallelepipedo"));
		gestore.aggiungiArticolo(new Penna("Bic", "Stilo", 2, "Nero"));
		gestore.aggiungiArticolo(new Gomma("Normale", "Faber-Castel", 6, new Dimensione(5, 5, 8), "Parallelepipedo"));
		gestore.aggiungiArticolo(new Gomma("Normale", "Bic", 3, new Dimensione(5, 5, 3), "Trapezio"));
		gestore.aggiungiArticolo(new Gomma("Mini", "Faber-Castel", 3, new Dimensione(5, 2, 3), "Parallelepipedo"));
		gestore.aggiungiArticolo(new Gomma("Mini", "Faber-Castel", 3, new Dimensione(5, 2, 3), "Parallelepipedo"));
		gestore.aggiungiArticolo(new Penna("Bic", "Stilo", 3, "Verde"));
		gestore.aggiungiArticolo(new Gomma("Mini", "Faber-Castel", 3, new Dimensione(5, 2, 3), "Parallelepipedo"));
		gestore.aggiungiArticolo(new Penna("Bic", "Stilo", 3, "blu"));
		
		
		// stampo le giacenze
		gestore.giacenze();
		
		//stampo valore totale delle giacenze
		gestore.totaleGiacenze();
		
		// creo clienti
		gestore.addCliente(new Privato("Davide"));
		gestore.addCliente(new Privato("Golia", 1));
		gestore.addCliente(new Azienda("Alluminox"));
		gestore.addCliente(new Azienda("Esselunga", 300));
		gestore.addCliente(new Azienda("Conad", 300));
		gestore.addCliente(new Azienda("Gigante", 300));

		// creo un ordine
		Ordine ord1 = new Ordine(oggi, 1, new Privato("Davide"), 2);
		
		// inserisco gli articoli nell'ordine
		
		
		
		/*	
		// creo una cartoleria con spazio per 10 articoli
		Cartoleria smile = new Cartoleria(10);
		
		// la riempio
		
		boolean inserito = true;
		inserito = smile.add(new Gomma("Mini", "Faber-Castel", 3, new Dimensione(5, 2, 3), "Parallelepipedo"));
		if(!inserito) System.out.println("Il magazzino è pieno");
		
		inserito = smile.add(new Penna("Bic", "Stilo", 2, "Nero"));
		if(!inserito) System.out.println("Il magazzino è pieno");
		
		inserito = smile.add(new Gomma("Normale", "Faber-Castel", 6, new Dimensione(5, 5, 8), "Parallelepipedo"));
		if(!inserito) System.out.println("Il magazzino è pieno");
		
		inserito = smile.add(new Gomma("Normale", "Bic", 3, new Dimensione(5, 5, 3), "Trapezio"));
		if(!inserito) System.out.println("Il magazzino è pieno");
		
		inserito = smile.add(new Gomma("Mini", "Faber-Castel", 3, new Dimensione(5, 2, 3), "Parallelepipedo"));
		if(!inserito) System.out.println("Il magazzino è pieno");
		
		inserito = smile.add(new Gomma("Mini", "Faber-Castel", 3, new Dimensione(5, 2, 3), "Parallelepipedo"));
		if(!inserito) System.out.println("Il magazzino è pieno");
		
		inserito = smile.add(new Penna("Bic", "Stilo", 3, "Verde"));
		if(!inserito) System.out.println("Il magazzino è pieno");
		
		inserito = smile.add(new Penna("Bic", "Stilo", 1, "Blu"));
		if(!inserito) System.out.println("Il magazzino è pieno");
		
		inserito = smile.add(new Penna("Bic", "Stilo", 1, "Blu"));
		if(!inserito) System.out.println("Il magazzino è pieno");
		
		inserito = smile.add(new Penna("Bic", "Stilo", 1, "Blu"));
		if(!inserito) System.out.println("Il magazzino è pieno");
		
		inserito = smile.add(new Penna("Bic", "Stilo", 1, "Blu"));
		if(!inserito) System.out.println("Il magazzino è pieno");
		
		
		System.out.println("Stampo giacenze: ");
		smile.stampaGiacenze();
		
		System.out.println("Valore totale giacenze: " + smile.stampaValoreTotaleGiacenze());
		
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
		boolean ordine_inserito = false;
		ordine_inserito = ord1.addArticolo(smile.getArticolo(0));
		if(!ordine_inserito) System.out.println("Ordine non inserito");
		else smile.eliminaArticoli(0);

		ordine_inserito = ord1.addArticolo(smile.getArticolo(1));
		if(!ordine_inserito) System.out.println("Ordine non inserito");
		else smile.eliminaArticoli(1);
		
		ordine_inserito = ord1.addArticolo(smile.getArticolo(1));
		if(!ordine_inserito) System.out.println("Ordine non inserito");
		else smile.eliminaArticoli(1);
		
		// riepilogo
		System.out.println("Totale ordine: " + ord1.totale());
		System.out.println("Saldo cliente: " + clienti[0].getSaldo());
		ord1.riepilogo_ordine();
		
		// chiudo l'ordine
		boolean ordine_chiuso = ord1.chiudiOrdine();
		System.out.println("Ordine chiuso: " + ordine_chiuso);
		
		// se l'ordine va a buon fine mi faccio restituire l'elenco degli
		// articoli ordinati e li tolgo dal magazzino
		if(ordine_chiuso) {
			smile.eliminaArticoli(ord1.elencoArticoli());
		}
		else {
			smile.addArticoli(ord1.elencoArticoli());
			System.out.println("Ordine non andato a buon fine");
		}
		
		
		//!!! FINE PRIMO ORDINE
		
		// ricontrollo le giacenze
		System.out.println("Stampo giacenze: ");
		smile.stampaGiacenze();
		
		
		
		// reinserisco un articolo per controllare che venga messo nella prima posizione
		inserito = smile.add(new Penna("Bic", "Stilo", 1, "Blu"));
		if(!inserito) System.out.println("Il magazzino è pieno");
		
		System.out.println("Stampo giacenze: ");
		smile.stampaGiacenze();
		
		
		//!!! SECONDO ORDINE
		// effetto gli altri ordini
		Ordine ord2 = new Ordine(oggi, 2, clienti[1], 3);
		
		ordine_inserito = ord2.addArticolo(smile.getArticolo(0));
		if(!ordine_inserito) System.out.println("Ordine non inserito");
		else smile.eliminaArticoli(0);
		
		ordine_inserito = ord2.addArticolo(smile.getArticolo(3));
		if(!ordine_inserito) System.out.println("Ordine non inserito");
		else smile.eliminaArticoli(3);
		
		// non esiste questo articolo
		ordine_inserito = ord2.addArticolo(smile.getArticolo(1));
		if(!ordine_inserito) System.out.println("Ordine non inserito");
		else smile.eliminaArticoli(1);
		
		
		// chiudo l'ordine con ancora uno spazio nel carrello vuoto
		// riepilogo
		System.out.println("Totale ordine: " + ord2.totale());
		System.out.println("Saldo cliente: " + clienti[1].getSaldo());
		ord2.riepilogo_ordine();
		
		
		// chiudo l'ordine
		ordine_chiuso = ord2.chiudiOrdine();
		System.out.println("Ordine chiuso: " + ordine_chiuso);
		
		// se l'ordine va a buon fine mi faccio restituire l'elenco degli
		// articoli ordinati e li tolgo dal magazzino
		if(ordine_chiuso) {
			smile.eliminaArticoli(ord2.elencoArticoli());
		}
		else {
			smile.addArticoli(ord2.elencoArticoli());
			System.out.println("Ordine non andato a buon fine");
		}
		
		//!!! FINE SECONDO ORDINE
		
		//!!! TERZO ORDINE
		// effetto gli altri ordini
		Ordine ord3 = new Ordine(oggi, 2, clienti[2], 10);
		
		ordine_inserito = ord3.addArticolo(smile.getArticolo(0));
		if(!ordine_inserito) System.out.println("Ordine non inserito");
		else smile.eliminaArticoli(0);
		
		ordine_inserito = ord3.addArticolo(smile.getArticolo(2));
		if(!ordine_inserito) System.out.println("Ordine non inserito");
		else smile.eliminaArticoli(2);
		
		ordine_inserito = ord3.addArticolo(smile.getArticolo(7));
		if(!ordine_inserito) System.out.println("Ordine non inserito");
		else smile.eliminaArticoli(7);
		
		ordine_inserito = ord3.addArticolo(smile.getArticolo(9));
		if(!ordine_inserito) System.out.println("Ordine non inserito");
		else smile.eliminaArticoli(9);
		
		// chiudo l'ordine con ancora uno spazio nel carrello vuoto
		// riepilogo
		System.out.println("Totale ordine: " + ord3.totale());
		System.out.println("Saldo cliente: " + clienti[2].getSaldo());
		ord3.riepilogo_ordine();
		
		
		// chiudo l'ordine
		ordine_chiuso = ord3.chiudiOrdine();
		System.out.println("Ordine chiuso: " + ordine_chiuso);
		
		// se l'ordine va a buon fine mi faccio restituire l'elenco degli
		// articoli ordinati e li tolgo dal magazzino
		if(ordine_chiuso) {
			smile.eliminaArticoli(ord3.elencoArticoli());
		}
		else {
			smile.addArticoli(ord3.elencoArticoli());
			System.out.println("Ordine non andato a buon fine");
		}
		
		//!!! FINE TERZO ORDINE
		
		// ricontrollo le giacenze
		System.out.println("Stampo giacenze: ");
		smile.stampaGiacenze();
		
		//!!! QUARTO ORDINE
		// effetto gli altri ordini
		Ordine ord4 = new Ordine(oggi, 2, clienti[3], 10);
		
		ordine_inserito = ord4.addArticolo(smile.getArticolo(3));
		if(!ordine_inserito) System.out.println("Ordine non inserito");
		else smile.eliminaArticoli(3);
		
		ordine_inserito = ord4.addArticolo(smile.getArticolo(4));
		if(!ordine_inserito) System.out.println("Ordine non inserito");
		else smile.eliminaArticoli(4);
		
		ordine_inserito = ord4.addArticolo(smile.getArticolo(5));
		if(!ordine_inserito) System.out.println("Ordine non inserito");
		else smile.eliminaArticoli(5);
		
		ordine_inserito = ord4.addArticolo(smile.getArticolo(6));
		if(!ordine_inserito) System.out.println("Ordine non inserito");
		else smile.eliminaArticoli(6);
		
		ordine_inserito = ord4.addArticolo(smile.getArticolo(8));
		if(!ordine_inserito) System.out.println("Ordine non inserito");
		else smile.eliminaArticoli(8);
		
		// chiudo l'ordine con ancora uno spazio nel carrello vuoto
		// riepilogo
		System.out.println("Totale ordine: " + ord4.totale());
		System.out.println("Saldo cliente: " + clienti[2].getSaldo());
		ord4.riepilogo_ordine();
		
		
		// chiudo l'ordine
		ordine_chiuso = ord4.chiudiOrdine();
		System.out.println("Ordine chiuso: " + ordine_chiuso);
		
		// se l'ordine va a buon fine mi faccio restituire l'elenco degli
		// articoli ordinati e li tolgo dal magazzino
		if(ordine_chiuso) {
			smile.eliminaArticoli(ord4.elencoArticoli());
		}
		else {
			smile.addArticoli(ord4.elencoArticoli());
			System.out.println("Ordine non andato a buon fine");
		}
		
		//!!! FINE QUARTO ORDINE
		
		// ricontrollo le giacenze
		System.out.println("Stampo giacenze: ");
		smile.stampaGiacenze();
		
		System.out.println("**TEST CHIUSURA ORDINE CONCORRENTE**");
		//!!! Testo cosa accade quando creo due ordini contemporaneamente
		// che hanno al loro interno alcuni oggetti in comune
		// e il primo viene chiuso prima del sencondo
		
		inserito = smile.add(new Penna("Pentel", "Sfera", 3, "Nera"));
		if(!inserito) System.out.println("Il magazzino è pieno");
		
		inserito = smile.add(new Penna("Bic", "Stilo", 1, "Blu"));
		if(!inserito) System.out.println("Il magazzino è pieno");
		
		inserito = smile.add(new Penna("Uni-Ball", "Sfera", 5, "Arancio"));
		if(!inserito) System.out.println("Il magazzino è pieno");
		
		
		Ordine od1 = new Ordine(oggi, 2, clienti[4], 10);
		Ordine od2 = new Ordine(oggi, 2, clienti[5], 10);
		
		// aggiungo l'articolo 0 ad entrambi
		ordine_inserito = od1.addArticolo(smile.getArticolo(0));
		if(!ordine_inserito) System.out.println("Ordine non inserito");
		else smile.eliminaArticoli(0);
		
		ordine_inserito = od1.addArticolo(smile.getArticolo(1));
		if(!ordine_inserito) System.out.println("Ordine non inserito");
		else smile.eliminaArticoli(1);
		
		ordine_inserito = od2.addArticolo(smile.getArticolo(0));
		if(!ordine_inserito) System.out.println("Ordine non inserito");
		else smile.eliminaArticoli(0);
		
		ordine_inserito = od2.addArticolo(smile.getArticolo(2));
		if(!ordine_inserito) System.out.println("Ordine non inserito");
		else smile.eliminaArticoli(2);
		
		// riepilogo
		System.out.println("Totale ordine: " + od1.totale());
		System.out.println("Saldo cliente: " + clienti[4].getSaldo());
		od1.riepilogo_ordine();
		
		// riepilogo
		System.out.println("Totale ordine: " + od2.totale());
		System.out.println("Saldo cliente: " + clienti[5].getSaldo());
		od2.riepilogo_ordine();
		
		// chiudo od1
		ordine_chiuso = od1.chiudiOrdine();
		System.out.println("Ordine chiuso: " + ordine_chiuso);
		
		// se l'ordine va a buon fine mi faccio restituire l'elenco degli
		// articoli ordinati e li tolgo dal magazzino
		if(ordine_chiuso) {
			smile.eliminaArticoli(od1.elencoArticoli());
		}
		else {
			smile.addArticoli(od1.elencoArticoli());
			System.out.println("Ordine non andato a buon fine");
		}
		
		// chiudo od2
		ordine_chiuso = od2.chiudiOrdine();
		System.out.println("Ordine chiuso: " + ordine_chiuso);
		
		// se l'ordine va a buon fine mi faccio restituire l'elenco degli
		// articoli ordinati e li tolgo dal magazzino
		if(ordine_chiuso) {
			smile.eliminaArticoli(od2.elencoArticoli());
		}
		else {
			smile.addArticoli(od2.elencoArticoli());
			System.out.println("Ordine non andato a buon fine");
		}
		
		System.out.println("Saldo cliente: " + clienti[4].getSaldo());
		System.out.println("Saldo cliente: " + clienti[5].getSaldo());
	*/	
	}

}
