package model;

import java.util.List;
import java.util.ArrayList;

import helper.Utils;

public class Atendimento {

	private List<PrestServico> pserv = new ArrayList<>();
	private List<Venda> vendas = new ArrayList<>();
	private double total = 0;

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTotal() {
		return total;
	}
	
	public Atendimento(PrestServico pserv) {
		this.pserv.add(pserv);
		total += pserv.getValor();
	}
	
	public Atendimento(Venda vend) {
		this.vendas.add(vend);
		total += vend.getValor();
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
		for(PrestServico p : pserv) {
			txt = txt + p.toString() + "\n";
		}
		
		txt = txt + "\n";
		
		for(Venda v : vendas) {
			txt = txt + v.toString() + "\n";
		}
		txt = txt + "\nTotal: " + Utils.valorToString(this.total) + "\n------------------------------------"; 
		
		return txt;
	}
}
