package interfacce.Esercizio3;

public class TestOperazione {

	static void testAddizione() {
		Addizione add = new Addizione(3, 2);
		add.calcolaOperazione();
		add.stampaRisultato();
	}
	
	static void testDivisione() {
		Divisione div = new Divisione(3, 2);
		div.calcolaOperazione();
		div.stampaRisultato();
	}
	

	static void testMoltiplicazione() {
		Moltiplicazione mol = new Moltiplicazione(3, 2);
		mol.calcolaOperazione();
		mol.stampaRisultato();
	}

	
	public static void main(String[] args) {
		testAddizione();
		testDivisione();
		testMoltiplicazione();
	}

}
