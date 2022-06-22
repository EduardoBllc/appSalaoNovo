package model;

public abstract class Pessoa {
	public String tipo;
	private String nome;

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Pessoa(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return tipo + ": " + nome;
	}
}
