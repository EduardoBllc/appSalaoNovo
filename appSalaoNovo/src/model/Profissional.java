package model;

import java.util.ArrayList;
import java.util.List;

public class Profissional extends Pessoa {

	private static String tipo = "Profissional";
	private double faturamento = 0;
	private List<Servico> listaServ = new ArrayList<>();

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
	
	public void addListaServ(Servico serv) {
		this.listaServ.add(serv);
	}
	
	public List<Servico> getListaServ() {
		return this.listaServ;
	}

}
