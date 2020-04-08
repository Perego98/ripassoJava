package interfacce.Esercizio2;

public class main {

	public static void main(String[] args) {
		Distributore d1 = new Distributore("Desio", "Mandia Antonio", 1000, 275, 1.75f);
		Distributore d2 = new Distributore("Seregno", "Curioni A. & Pozzi S.", 700, 675, 1.95f);
		Distributore d3 = new Distributore("Carate Brianza", "Spadone Carlo e Scorza Alberto", 1000, 875, 2.00f);

		System.out.println(d1.toString());
		System.out.println(d2.toString());
		System.out.println(d3.toString());
		
		d1.erogaCarburante();
		d1.erogaCarburante();
				
		d1.erogaIncassi();
			
		d1.aggiungiCarburante(7000);
		
		System.out.println(d1.toString());
		System.out.println(d2.toString());
		System.out.println(d3.toString());
		
		
		d2.erogaCarburante();
		d2.erogaCarburante();
		d2.erogaCarburante();
		d2.erogaCarburante();
		
				
		d2.erogaIncassi();
		
		
		System.out.println(d1.toString());
		System.out.println(d2.toString());
		System.out.println(d3.toString());
		
		System.out.println("d1 == d3 " + d1.compareTo(d3));
		
		System.out.println("d1 == d2 " + d1.compareTo(d2));
	}

}
