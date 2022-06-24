package model;

import java.util.List;
import java.util.ArrayList;

import helper.Utils;

public class Atendimento {

	private Cliente cliente;

	private List<PrestServico> pserv = new ArrayList<>();
	private List<Venda> vendas = new ArrayList<>();

	private double total = 0;
	
	/***
	 * Construtor para serviços
	 * @param cli
	 * @param pserv
	 */
	public Atendimento(Cliente cli, PrestServico pserv) {
		this.cliente = cli;
		this.pserv.add(pserv);
		total += pserv.getValor();
	}

	/***
	 * Construtor para vendas
	 * @param cli
	 * @param vend
	 */
	public Atendimento(Cliente cli, Venda vend) {
		this.cliente = cli;
		this.vendas.add(vend);
		total += vend.getValor();
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

	public void addPserv(PrestServico pserv) {
		this.pserv.add(pserv);
		total += pserv.getValor();
	}

	public void addVenda(Venda vend) {
		this.vendas.add(vend);
		total += vend.getValor();
	}

	@Override
	public String toString() {

		String txt = "------------------------------------";
		for (PrestServico p : pserv) {
			txt = txt + p.toString() + "\n";
		}

		txt = txt + "\n";

		for (Venda v : vendas) {
			txt = txt + v.toString() + "\n";
		}
		txt = txt + "\nTotal: " + Utils.valorToString(this.total) + "\n------------------------------------";

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
