package cartoleria;

public class Articolo {

		private String marca;
		private String modello;
		private float costo;
		private float prezzo_vendita;
		
		public Articolo() {
			this.marca = "";
			this.modello = "";
			this.costo = 0;
			prezzo_vendita = 0;
		}
		
		public Articolo(String marca, String modello, float costo) {
			this.marca = marca;
			this.modello = modello;
			this.costo = costo;
			prezzo_vendita = costo*2;
		}
		
		public float getCosto() {
			return costo;
		}
		
		public float getPrezzoVendita() {
			return prezzo_vendita;
		}

		@Override
		public String toString() {
			return "Marca: " + marca + " Modello: " + modello + " Costo: " + costo + " Prezzo di vendita: " + prezzo_vendita;
		}
		
		

}
