package model;

import java.util.List;
import java.util.ArrayList;

import helper.Utils;

public class Atendimento {

	private Cliente cliente;

	private List<PrestServico> pserv = new ArrayList<>();
	private List<Produto> prod = new ArrayList<>();

	private double total = 0;
	private String status;
	
	/***
	 * Construtor para serviços
	 * @param cli
	 * @param pserv
	 */
	public Atendimento(Cliente cli, PrestServico pserv) {
		this.status = "Atendimento em andamento";
		this.cliente = cli;
		this.pserv.add(pserv);
		total += pserv.getValor();
	}

	/***
	 * Construtor para vendas
	 * @param cli
	 * @param vend
	 */
	public Atendimento(Cliente cli, Produto prod) {
		this.cliente = cli;
		this.prod.add(prod);
		total += prod.getValor();
	}


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTotal() {
		return total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void addPserv(PrestServico pserv) {
		this.pserv.add(pserv);
		total += pserv.getValor();
	}

	public void addVenda(Produto prod) {
		this.prod.add(prod);
		total += prod.getValor();
	}

	@Override
	public String toString() {

		String txt = "---------------- Atendimento ----------------\n";
		for (PrestServico p : pserv) {
			txt = txt + p.toString() + "\n";
		}

		for (Produto v : prod) {
			txt = txt + v.toString() + "\n";
		}
		txt = txt + "Total: " + Utils.valorToString(this.total) + "\n--------------------------------------------";

		return txt;
	}

	/***
	 * Listagem para método Teste.listarAtendimentos()
	 * @return O cliente e o subtotal(valor atual do atendimento antes de ser fechado)
	 */
	public String listar() {
		return this.getCliente().toString() + "\nSubtotal: " + total;
	}
}
