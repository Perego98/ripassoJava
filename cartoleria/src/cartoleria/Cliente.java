package cartoleria;

public class Cliente {
	
	private String nome;
	private float saldo;
	
	public Cliente(String nome) {
		this.nome = nome;
		this.saldo = (int) (Math.random()*1000);
	}
	
	public Cliente(String nome, float saldo) {
		this.nome = nome;
		this.saldo = saldo;
	}


	public String getNome() {
		return nome;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}	
	
	

	
}
