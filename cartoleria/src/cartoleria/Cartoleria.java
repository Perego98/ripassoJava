package cartoleria;



public class Cartoleria {

	private Articolo[] magazzino;

	public Cartoleria(int spazio_magazzino) {
		this.magazzino = new Articolo[spazio_magazzino];
	}
	
	public void stampaGiacenze() {
		for(int i = 0; i < magazzino.length ; i++) {
			if (magazzino[i] != null) {
				System.out.println(magazzino[i].toString());
			}		
		}
	}
	
	public float stampaValoreTotaleGiacenze() {
		float valore_totale = 0;
		for(int i = 0; i < magazzino.length ; i++) {
			if (magazzino[i] != null) {
				valore_totale += magazzino[i].getPrezzoVendita();
			}		
		}
		return valore_totale;
	}
	

	// scorro tutto il vettore fino a che non trovo una posizione vuota (a null)
	// se la trovo setto l'id del mio articolo con la posizione in cui è inserito
	// in questo modo quando un cliente comprerà un articolo saprò dove si troverà
	// il moi articolo e saprò chi eliminare
	public boolean add(Articolo art) {
		boolean inserito = false;
		for(int i = 0; i < magazzino.length && !inserito; i ++) {
			if(magazzino[i] == null) {
				art.setId(i);
				magazzino[i] = art;
				inserito = true;
			}
		}
		return inserito;
	}
	
	public Articolo getArticolo(int id) {
		if(magazzino[id] != null) {
			return magazzino[id];
		}
		return null;
	}
	
	public void eliminaArticoli(int id) {
		if(id >= 0 && id < magazzino.length)
			magazzino[id] = null;
	}
	
	public void eliminaArticoli(Articolo[] elenco) {
		for(int i = 0; i < elenco.length; i++) {
			if(elenco[i] != null) {
				magazzino[elenco[i].getId()] = null;
			}			
		}
	}
	
	// reinserisco gli articoli che erano stati tolti da un ordine
	// che non è andato a buon fine
	public void addArticoli(Articolo [] articoli) {
		for(int i = 0; i< articoli.length; i++) {
			if(articoli[i] != null) {
				if(magazzino[articoli[i].getId()] == null) {
					magazzino[articoli[i].getId()] = articoli[i];
					}
				else {
					System.out.println("Cella " + i + " del magazzino gia occupata");
				}
			}
		}
	}
	
}// fine Cartoleria
