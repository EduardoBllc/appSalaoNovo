package view;

import java.util.Scanner;

import helper.BaseDados;
import helper.Utils;
import model.Atendimento;
import model.Cliente;
import model.PrestServico;
import model.Produto;
import model.Profissional;
import model.Servico;

import java.util.List;
import java.util.ArrayList;

public class Teste {
	static Scanner teclado = new Scanner(System.in);
	static List<Atendimento> atendimentos = new ArrayList<>();
	static List<Profissional> pro = new ArrayList<>();
	static List<Servico> serv = new ArrayList<>();
	static BaseDados base = new BaseDados();
	static int cont = 0;
	
	public static void main(String[] args){
		
		pro.addAll(base.getPro());
		serv.addAll(base.getServ());
		
		Teste.menu();
		
	}
	
	private static void menu(){
		int opcao = 0;
		System.out.println("=======================================");
		System.out.println("============ Universo Pink ============");
		System.out.println("================ Caixa ================");
		System.out.println("=======================================");
		System.out.println("Selecione uma opcao:");
		System.out.println("1 - Novo atendimento");
		System.out.println("2 - Listar atendimentos ativos");
		System.out.println("3 - Checar atendimento");
		System.out.println("4 - Fechar dia");
		
		try{
			opcao = Integer.parseInt(Teste.teclado.nextLine());
		}catch(NumberFormatException e){
			System.out.println("Não foi possível selecionar uma opção, tente novamente.");
			Utils.pausar(2);
			Teste.menu();
		}
			
		switch(opcao){
			case 1:
				Teste.inicioAtendimento();
				break;
			case 2:
				Teste.listarAtendimentos();
				break;
			case 3:
				Teste.checarAtendimento();
				break;
			case 4:
				Teste.fecharDia();
				break;
			default:
				System.out.println("Opcão inválida, tente novamente.");
				Teste.menu();
				break;
		}
	}
	
	private static void inicioAtendimento() {
		
		//Recebendo o cliente
		System.out.println("Digite o nome da cliente:");
		Cliente cli = new Cliente(Teste.teclado.nextLine());
		
		//Recebendo o tipo de atendimento
		System.out.println("Irá consumir um serviço ou um produto?"
				+ "\n1 - Serviço"
				+ "\n2 - Produto");
		
		int opcao = 0;
		try {
			opcao = Integer.parseInt(Teste.teclado.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("Não foi possível selecionar uma opção, tente novamente.");
			Utils.pausar(2);
			Teste.inicioAtendimento();
		}
		//Caso for um atendimento de serviço, inicia o método novoServico para retornar um PrestServico no construtor do Atendimento
		if(opcao == 1) {
			Atendimento atend = new Atendimento(cli, Teste.novoServico());
			atendimentos.add(atend);
			System.out.println(atend);
			Utils.pausar(2);
		//Caso for um atendimento de produto, inicia o método novoProduto para retornar um Produto no construtor do Atendimento
		}else if(opcao == 2) {
			Atendimento atend = new Atendimento(cli, Teste.novoProduto());
			atendimentos.add(atend);
			System.out.println(atend);
			Utils.pausar(2);
		}else {
			System.out.println("Por favor, digite uma opção válida");
			Utils.pausar(2);
			Teste.menu();
		}
		
		Utils.pausar(4);
		
		opcao = Teste.lacoAtendimento();
		
		while(opcao != 0) {
			//Caso for um atendimento de serviço, inicia o método novoServico para retornar um PrestServico no construtor do Atendimento
			if(opcao == 1) {
				atendimentos.get(cont).addPserv(novoServico());
				System.out.println(atendimentos.get(cont));
			//Caso for um atendimento de produto, inicia o método novoProduto para retornar um Produto no construtor do Atendimento
			}else if(opcao == 2) {
				atendimentos.get(cont).addVenda(novoProduto());
				System.out.println(atendimentos.get(cont));
			}
			Utils.pausar(2);
			opcao = Teste.lacoAtendimento();
		}
		
		System.out.println("Atendimento registrado!");
		Utils.pausar(2);
		Teste.cont ++;
		Teste.menu();
		
	}
	
	private static PrestServico novoServico(){
		
			//Listando os Profissionais
			System.out.println("Informe o profissional:");
			for(int i = 0; i < pro.size(); i ++) {
				System.out.println((i + 1) + " - " + pro.get(i).getNome());
			}
			int opcaoPro = 0;
			
			//Recebendo o profissional
			try {
				opcaoPro = (Integer.parseInt(teclado.nextLine()) - 1);
			}catch(NumberFormatException e) {
				System.out.println("Não foi possível selecionar uma opção, tente novamente.");
				Utils.pausar(2);
				Teste.novoServico();
			}
			
			//Listando os serviços
			System.out.println("Informe o serviço:");
			for(int i = 0; i < pro.get(opcaoPro).getListaServ().size(); i ++) {
				System.out.println((i + 1) + " - " + pro.get(opcaoPro).getListaServ().get(i).getNome());
			}
			
			int opcaoServ = 0;
			
			//Recebendo o serviço
			try {
				opcaoServ = (Integer.parseInt(teclado.nextLine()) - 1);
			}catch(NumberFormatException e) {
				System.out.println("Não foi possível selecionar uma opção, tente novamente.");
				Utils.pausar(2);
				Teste.menu();
			}
			
			if(pro.get(opcaoPro).getListaServ().get(opcaoServ).getValor() == 0) {
				System.out.println("Informe o preço do(a) " + pro.get(opcaoPro).getListaServ().get(opcaoServ).getNome() + ":");
				return new PrestServico(pro.get(opcaoPro), new Servico(pro.get(opcaoPro).getListaServ().get(opcaoServ).getNome(),Double.parseDouble(Teste.teclado.nextLine())));
			}
			//Retornando o PrestServiço recebido
			return new PrestServico(pro.get(opcaoPro),pro.get(opcaoPro).getListaServ().get(opcaoServ));
	}
	
	/***
	 * Método para retornar um produto
	 * @return Produto
	 */
	public static Produto novoProduto() {
		String nome;
		double valor;
		
		//Recebendo o produto
		System.out.println("Informe o nome do produto:");
		nome = Teste.teclado.nextLine();
		System.out.println("Informe o preço do produto:");
		valor = Double.parseDouble(Teste.teclado.nextLine());
		
		//Retornando o Produto recebido
		return new Produto(nome,valor);
		
	}
	/***
	 * Laço para adicionar serviços ou produtos no atendimento
	 * @return opção, sendo 0 = fim de atendimento, 1 = novo serviço e 2 = novo produto
	 */
	public static int lacoAtendimento() {
		
		//Iniciando um laço
		int opcaoLaco = 0;

		System.out.println("Deseja adicionar outro serviço ou produto?"
				+ "\n0 - Não\n1 - Sim");
		try {
			opcaoLaco = Integer.parseInt(Teste.teclado.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("Não foi possível selecionar uma opção, tente novamente.");
			Utils.pausar(2);
			return 0;
		}
		if(opcaoLaco == 1) {
			//Recebendo o tipo de atendimento
			System.out.println("Irá consumir um serviço ou um produto?"
					+ "\n1 - Serviço"
					+ "\n2 - Produto");
			try {
				opcaoLaco = Integer.parseInt(Teste.teclado.nextLine());
			}catch(NumberFormatException e) {
				System.out.println("Não foi possível selecionar uma opção, tente novamente.");
				Utils.pausar(2);
				return 0;
			}
			
			if(opcaoLaco == 1) {
				return 1;
			}else if(opcaoLaco == 2) {
				return 2;
			}else {
				System.out.println("Por favor, digite uma opção válida.");
				Utils.pausar(2);
				return 0;
			}
		}else if(opcaoLaco == 0) {
			return opcaoLaco;
		}else {
			System.out.println("Por favor, digite uma opção válida.");
			Utils.pausar(2);
			return 0;
		}
		
	}
	
	private static void listarAtendimentos(){
		System.out.println("------------------------------------");
		for(Atendimento a : atendimentos){
			System.out.println(a.listar() + "\n");
		}
		System.out.println("------------------------------------");
		
		Utils.pausar(3);
		Teste.menu();
	}
	
	private static void checarAtendimento(){
		//TODO
	}
	
	private static void fecharDia(){
		//TODO
	}
}