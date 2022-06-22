package model;

import helper.Utils;

public class PrestServico {

	private Servico serv;
	private Profissional pro;
	private double valor;

	public PrestServico(Profissional pro, Servico serv, double valor) {
		this.pro = pro;
		this.serv = serv;
		this.valor = valor;
	}

	public PrestServico(Profissional pro, Servico serv) {
		this.pro = pro;
		this.serv = serv;
		this.valor = serv.getValor();
	}

	public void setServico(Servico servico) {
		this.serv = servico;
	}

	public Servico getServico() {
		return this.serv;
	}

	public void setProfissional(Profissional profissional) {
		this.pro = profissional;
	}

	public Profissional getProfissional() {
		return this.pro;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return this.valor;
	}
	
	@Override
	public String toString() {

		return "\n" + this.pro + "\n" + this.serv + "\nValor: " + Utils.valorToString(this.valor);
	}
}
