package esercizio1;

public class esercizio1 {

	public static void main(String[] args) {
		
		Stagista [] stagisti = new Stagista[3];
		stagisti[0] = new Stagista("Perego", "Daniele", "PRGDNL98R06D286W", "Cesano Maderno", 0, 0);// 06/10/1998
		stagisti[1] = new Stagista("Golia", "Davide", "GLODVD39E13D286N", "Desio", 0, 0); // 13/05/1939
		stagisti[2] = new Stagista("Franco", "Lucia", "FRNLCU11A01D286P", "Desio", 0, 0); // 01/01/2011
		
		int max = 0;
		for(int i = 0; i < stagisti.length; i++) {
			if(stagisti[max].getDataNascita().getTimeInMillis() < stagisti[i].getDataNascita().getTimeInMillis())
				max = i;
		}
		
		System.out.println(stagisti[max].toString());
		
	}

}
