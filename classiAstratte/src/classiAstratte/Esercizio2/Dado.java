package classiAstratte.Esercizio2;

import java.util.Random;

public class Dado extends Lancio{

	
	public Dado() {
	}

	@Override
	public int lancio() {
		Random dado = new Random();
		return dado.nextInt(7);
	}

	@Override
	public void stampaLancio() {
		System.out.println("Lancio dado: " + lancio());
	}

}
