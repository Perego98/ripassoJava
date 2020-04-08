package classiAstratte.Esercizio1;

public class Cilindro extends CalcoloVolume{

	private float raggio;
	
	public Cilindro(float raggio, float altezza) {
		this.raggio = raggio;
		setAltezza(altezza);
		setArea((float)(raggio*raggio*Math.PI));
	}

	@Override
	public String toString() {
		return "Cilindro: " + super.toString() + " raggio=" + raggio;
	}

		
	
	

}
