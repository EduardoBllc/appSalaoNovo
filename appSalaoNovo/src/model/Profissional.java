package model;

public class Profissional extends Pessoa {

	private static String tipo = "Profissional";
	private double faturamento = 0;

	public Profissional(String nome) {
		super(nome);
		super.tipo = tipo;
	}

	public void addFaturamento(double valor) {
		this.faturamento += valor;
	}

	public double getFaturamento() {
		return faturamento;
	}

}
