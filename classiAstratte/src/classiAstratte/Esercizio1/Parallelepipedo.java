package classiAstratte.Esercizio1;

public class Parallelepipedo extends CalcoloVolume{
	
	private float base1;
	private float base2;
	public Parallelepipedo(float base1, float base2, float altezza) {
		this.base1 = base1;
		this.base2 = base2;
		setAltezza(altezza);
		setArea(base1*base2);
	}
	
	@Override
	public String toString() {
		return "Parallelepipedo: " + super.toString() + " base1=" + base1 + ", base2=" + base2;
	}
	
	
	
}
