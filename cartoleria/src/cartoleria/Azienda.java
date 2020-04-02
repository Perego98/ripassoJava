package cartoleria;

public class Azienda extends Cliente{

	

	public Azienda() {
		super("*404 name not found*", 0);
	}
	
	public Azienda(String nome, float saldo_conto_corrente) {
		super(nome, saldo_conto_corrente);
	}

	public Azienda(String nome) {
		super(nome);
	}


	
	
}
