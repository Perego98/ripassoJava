package esercizio5;
import java.util.Random;

public class TestQuestion {

	static void riempiQuesiti(Question [] quesiti) {
		quesiti[0] = new MultipleQuestion("Quante zampe ha un ragno?", "8", "7, 6, 5, 1, 3, 2", 1);
		quesiti[1] = new QuestionYesNo("Le mosche hanno solo 2 occhi?", "no", 1);
		quesiti[2] = new NumericQuestion("Quanto fa 6 + 4 ?", "10", 1);
		
		quesiti[3] = new MultipleQuestion("Quanti lati sono bagnati dall'acqua in una isola?", "4", "1, 2, 3", 1);
		quesiti[4] = new QuestionYesNo("Le mucche hanno 4 stomaci?", "si", 1);
		quesiti[5] = new NumericQuestion("Quanto fa 6 * 4 ?", "24", 1);
		
		quesiti[6] = new MultipleQuestion("quanti minuti servono per avere 2 ore?", "120", "70, 100, 60, 15, 36, 27", 1);
		quesiti[7] = new QuestionYesNo("i pinguini volano?", "no", 1);
		quesiti[8] = new NumericQuestion("Quanto fa 18 / 2 ?", "9", 1);
		

	}
	
	static void erogaDomande(Question [] quesiti) {
		
		boolean [] uscito = new boolean[10];
		int punteggio = 0;
		
		
		Random ran = new Random(); 
        int nxt = 0;
 
		for(int i = 0; i < 3;) {
			nxt = ran.nextInt(10); 
			if(quesiti[nxt] != null) {
				if(uscito[nxt] == false) {
					uscito[nxt] = true;
					i++;
					punteggio += quesiti[i].ask();
				}				
			}
		}
		
		System.out.println("Punteggio: " + punteggio);
	}
	
	
	
	public static void main(String[] args) {

		Question [] quesiti = new Question[10];
		
		riempiQuesiti(quesiti);
		
		erogaDomande(quesiti);

		

	}

}
