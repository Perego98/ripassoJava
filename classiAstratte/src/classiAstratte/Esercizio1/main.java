package classiAstratte.Esercizio1;

public class main {

	public static void main(String[] args) {
		
		Cilindro a = new Cilindro(10, 20);
		a.printVolume();
		System.out.println(a.toString());
		
		Parallelepipedo b = new Parallelepipedo(10, 10, 20);
		b.printVolume();
		System.out.println(b.toString());

	}

}
