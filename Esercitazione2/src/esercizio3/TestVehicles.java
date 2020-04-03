package esercizio3;

public class TestVehicles {

	static void creaVeicoli(Vehicle [] veicoli) {
		
		// rimpio con 10 elementi 5 moto e 5 auto
		veicoli[0] = new Motocycle("AA12345", "vespa", "vespa", false, 50);
		veicoli[1] = new Motocycle("cd67208", "vespa", "vespa", false, 125);
		veicoli[2] = new Motocycle("Fg17394", "vespa", "vespa", false, 200);
		veicoli[3] = new Motocycle("cz75392", "vespa", "vespa", false, 50);
		veicoli[4] = new Motocycle("ml19898", "vespa", "vespa", false, 200);
		
		veicoli[5] = new Car("ee000hg", "citroen", "c3 picasso", false, "SUV");
		veicoli[6] = new Car("BB03813", "citroen", "cactus", false, "utilitaria");
		veicoli[7] = new Car("ab456cd", "toyota", "vespa", false, "sport");
		veicoli[8] = new Car("ga129km", "fiat", "4x4", false, "race");
		veicoli[9] = new Car("xa149ax", "vespa", "vespa", false, "esposizione");
		
	}
	
	// metto in modo casuale il parametro guasto a false
	static void rompiVeicoli(Vehicle [] veicoli) {
		for(int i = 0; i < veicoli.length; i++) {
			if(((int) (Math.random()*10))%2 == 0) {
				veicoli[i].setGuasta(true);
			}
		}
	}
	
	static void stampaTargaVeicoliGuasti(Vehicle [] veicoli){
		for(int i = 0; i < veicoli.length; i++) {
			if(veicoli[i].isGuasta())
				System.out.println("Targa veicolo guasto: " +  veicoli[i].getTarga());
				
		}
	}
	
	public static void main(String[] args) {
		Vehicle [] veicoli = new Vehicle[10];

		creaVeicoli(veicoli);
		
		rompiVeicoli(veicoli);
		
		stampaTargaVeicoliGuasti(veicoli);
	}

}
