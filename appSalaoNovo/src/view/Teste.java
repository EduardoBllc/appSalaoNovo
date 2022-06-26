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
		System.out.println("===============================");
		System.out.println("======== Universo Pink ========");
		System.out.println("============ Caixa ============");
		System.out.println("===============================");
		System.out.println("Selecione uma opcao:");
		System.out.println("1 - Novo atendimento");
		System.out.println("2 - Listar atendimentos ativos");
		System.out.println("3 - Checar atendimento");
		System.out.println("4 - Fechar dia");
		
		try{
			opcao = Integer.parseInt(teclado.nextLine());
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
		Cliente cli = new Cliente(teclado.nextLine());
		
		//Recebendo o tipo de atendimento
		System.out.println("Irá consumir um serviço ou um produto?"
				+ "\n1 - Serviço"
				+ "\n2 - Produto");
		
		int opcao = 0;
		try {
			opcao = Integer.parseInt(teclado.next());
		}catch(NumberFormatException e) {
			System.out.println("Não foi possível selecionar uma opção, tente novamente.");
			Utils.pausar(2);
			Teste.inicioAtendimento();
		}
		//Caso for um atendimento de serviço, inicia o método novoServico para retornar um PrestServico no construtor do Atendimento
		if(opcao == 1) {
			Atendimento atend = new Atendimento(cli, Teste.novoServico());
			System.out.println(atend);
		//Caso for um atendimento de produto, inicia o método novoProduto para retornar um Produto no construtor do Atendimento
		}else if(opcao == 2) {
			Atendimento atend = new Atendimento(cli, Teste.novoProduto());
			System.out.println(atend);
		}else {
			System.out.println("Por favor, digite uma opção válida");
			Utils.pausar(2);
			Teste.inicioAtendimento();
		}
		
		System.out.println();
	}
	
	private static PrestServico novoServico(){
			//Listando os Profissionais
			System.out.println("Informe o profissional:");
			for(int i = 0; i < pro.size(); i ++) {
				System.out.println( i + " - " + pro.get(i));
			}
			int opcaoPro = 0;
			//Recebendo o profissional
			try {
				opcaoPro = Integer.parseInt(teclado.next());
			}catch(NumberFormatException e) {
				System.out.println("Não foi possível selecionar uma opção, tente novamente.");
				Utils.pausar(2);
				Teste.novoServico();
			}
			
			System.out.println("Informe o serviço:");
			for(int i = 0; i < serv.size(); i ++) {
				System.out.println( i + " - " + serv.get(i));
			}
			int opcaoServ = 0;
			//Recebendo o profissional
			try {
				opcaoServ = Integer.parseInt(teclado.next());
			}catch(NumberFormatException e) {
				System.out.println("Não foi possível selecionar uma opção, tente novamente.");
				Utils.pausar(2);
				Teste.novoServico();
			}
			return new PrestServico(pro.get(opcaoPro),serv.get(opcaoServ));
	}
	
	public static Produto novoProduto() {
		//Recebendo o produto
		System.out.println("Informe o nome do produto:");
		String nome = Teste.teclado.nextLine();
		System.out.println("Informe o preço do produto");
		return new Produto(nome,Integer.parseInt(teclado.next()));
		
	}
	
	private static void listarAtendimentos(){
		System.out.println("------------------------------------");
		for(Atendimento a : atendimentos){
			System.out.println(a.listar() + "\n");
		}
		System.out.println("------------------------------------");
	}
	
	private static void checarAtendimento(){
		//TODO
	}
	
	private static void fecharDia(){
		//TODO
	}
}