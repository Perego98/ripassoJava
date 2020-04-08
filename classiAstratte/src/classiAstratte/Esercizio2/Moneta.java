package classiAstratte.Esercizio2;

import java.util.Random;

public class Moneta extends Lancio{

	public Moneta() {
	}

	@Override
	public int lancio() {
		Random moneta = new Random();
		return moneta.nextInt(2);
	}

	@Override
	public void stampaLancio() {
		System.out.println("Lancio moneta: " + lancio());		
	}
	
	
	
	

}
