package classiAstratte.Esercizio2;

import java.util.Random;

public class main {

	static void conAbstract(){
		Dado dado = new Dado();
		Moneta moneta = new Moneta();
		
		dado.stampaLancio();
		moneta.stampaLancio();

	}
	
	static void senzaAbstract(){
		Random lancio = new Random();
		System.out.println("Lancio Dado: " + lancio.nextInt(7));
		System.out.println("Lancio Moneta: " + lancio.nextInt(2));
		
	}
	
	public static void main(String[] args) {
		
		conAbstract();
		
		senzaAbstract();
	}

}
