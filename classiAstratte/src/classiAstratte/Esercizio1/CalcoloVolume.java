package classiAstratte.Esercizio1;

public abstract class CalcoloVolume {

	private float area;
	private float altezza;
	
	public float volume() {
		return area * altezza;
	}
	
	public void printVolume() {
		System.out.println("Volume: " + volume());
	}

	public float getArea() {
		return area;
	}

	public float getAltezza() {
		return altezza;
	}

	public void setArea(float area) {
		this.area = area;
	}

	public void setAltezza(float altezza) {
		this.altezza = altezza;
	}

	@Override
	public String toString() {
		return "area=" + area + ", altezza=" + altezza + ", volume=" + volume();
	}
	
	
}
