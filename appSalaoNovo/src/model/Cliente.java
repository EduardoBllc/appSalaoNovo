package model;

public class Cliente extends Pessoa {

	private static String tipo = "Cliente";

	private String cpf;
	private String telefone;

	public Cliente(String nome) {
		super(nome);
		super.tipo = tipo;
	}

	public Cliente(String nome, String telefone) {
		super(nome);
		super.tipo = tipo;
		this.telefone = telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

}
