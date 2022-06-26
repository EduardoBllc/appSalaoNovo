package model;

public class Produto {
	public String tipo = "Produto";
	private String nome;
	private double valor;

	/***
	 * Consturo produto
	 * @param nome
	 * @param valor
	 */
	public Produto(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
	}

	public Produto(String nome) {
		this.nome = nome;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return this.valor;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	@Override
	public String toString() {
		if (valor != 0) {
			return "Nome do " + tipo + ": " + nome + "\nValor: " + valor;
		} else {
			return "Nome do " + tipo + ": " + nome;
		}
	}
}
