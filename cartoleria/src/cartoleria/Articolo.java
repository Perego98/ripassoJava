package cartoleria;

public class Articolo {
	
		private int id;
		private String marca;
		private String modello;
		private float costo;
		private float prezzo_vendita;
		
		public Articolo() {
			this.id = -1;
			this.marca = "";
			this.modello = "";
			this.costo = 0;
			prezzo_vendita = 0;
		}
		
		public Articolo( String marca, String modello, float costo) {
			this.id = -1;
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


		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return "ID: " + id + " Marca: " + marca + " Modello: " + modello + " Costo: " + costo + " Prezzo di vendita: " + prezzo_vendita;
		}
		
		

}
