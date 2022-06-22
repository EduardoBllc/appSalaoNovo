package view;

import model.Atendimento;
import model.Profissional;
import model.PrestServico;
import model.Servico;
import model.Venda;

public class Teste {
	
	public static void main(String[] args){
		
		Atendimento at1 = new Atendimento(new PrestServico(new Profissional("Duda"), new Servico("Micro"), 100.0));
		at1.addPserv(new PrestServico(new Profissional("Duda"), new Servico("Sombrancelha"), 60.0));
		at1.addPserv(new PrestServico(new Profissional("Vaninha"), new Servico("Corte"), 80.0));
		at1.addVenda(new Venda("Perfume vermelho",100.0));
		System.out.println(at1);
	}
}
