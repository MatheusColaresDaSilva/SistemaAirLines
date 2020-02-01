package br.com.codeitairlines.tripulacao;


public class Tripulacao {

	private String nome;

	public Tripulacao(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return  nome + " : " +this.getClass().getSimpleName();
	}
	
	
}
