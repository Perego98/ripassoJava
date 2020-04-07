package Esercizio2;

public class RegistrazioneAudio extends ElementoUditivo{

	public RegistrazioneAudio() {
		setTitolo("default");
		setDurata(0);
	}

	
	public RegistrazioneAudio(String titolo, int durata) {
		setTitolo(titolo);
		setDurata(durata);
	}

	@Override
	public void play() {

		String result = getTitolo();
		
		for(int i = 0; i < getVolume(); i++)
			result += "!";
		
		
		for(int i = 0; i < getDurata(); i++) {
			System.out.println(result);
		}		
		
	}

	@Override
	public String toString() {
		return "RegistrazioneAudio: volume=" + getVolume() + ", durata=" + getDurata() + ", titolo="
				+ getTitolo();
	}

	
	
}
