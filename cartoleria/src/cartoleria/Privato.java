package cartoleria;

public class Privato extends Cliente{
	
	public Privato() {
		super("*404 name not found*", 0);
	}
	
	// crea un privato con un saldo impostato da utente
	public Privato(String nome, float saldo_disponibile) {
		super(nome, saldo_disponibile);
	}

	// crea un privato con un saldo generato casualmente
	public Privato(String nome) {
		super(nome);
	}
}
