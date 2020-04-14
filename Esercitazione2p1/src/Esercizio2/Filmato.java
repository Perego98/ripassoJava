package Esercizio2;

public class Filmato extends ElementoAudioVideo{
	
	public Filmato() {
		setTitolo("default");
		setDurata(0);
	}
	
	public Filmato(String titolo, int durata) {
		setTitolo(titolo);
		setDurata(durata);
	}
	
	@Override
	public void play() {
		String result = getTitolo();
		
		for(int i = 0; i < getVolume(); i++)
			result += "!";
		
		for(int i = 0; i < getLuminosita(); i++)
			result += "*";
		
		
		for(int i = 0; i < getDurata(); i++) {
			System.out.println(result);
		}		
	}

	@Override
	public String toString() {
		return "Filmato: luminosita'=" + getLuminosita() + ", volume=" + getVolume() + ", durata="
				+ getDurata() + ", titolo=" + getTitolo();
	}



}
