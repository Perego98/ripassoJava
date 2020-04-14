package Esercizio2;

public class Immagine extends ElementoVisivo{

	public Immagine() {
		setTitolo("default");		
	}
	
	public Immagine(String titolo) {
		setTitolo(titolo);		
	}

	@Override
	public void show() {
		String result = getTitolo();
		
		
		for(int i = 0; i < getLuminosita(); i++)
			result += "*";
		
			System.out.println(result);	 
	}

	@Override
	public String toString() {
		return "Immagine: luminosita'=" + getLuminosita() + ", titolo=" + getTitolo();
	}

}
