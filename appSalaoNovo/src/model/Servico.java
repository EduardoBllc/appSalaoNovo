package model;

public class Servico extends Produto {

	private static String tipo = "Serviço";

	public Servico(String nome) {
		super(nome);
		super.tipo = tipo;
	}

	public Servico(String nome, double valor) {
		super(nome, valor);
	}
	
	@Override
	public String toString() {
		return "Nome do " + tipo + ": " + this.getNome();
	}
}
