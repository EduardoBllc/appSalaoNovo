package view;

import java.util.Scanner;

import helper.Utils;
import model.Atendimento;
import model.Cliente;

import java.util.List;
import java.util.ArrayList;

public class Teste {
	static Scanner teclado = new Scanner(System.in);
	static List<Atendimento> atendimentos = new ArrayList<>();
	
	public static void main(String[] args){
		
		
		
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
				Teste.novoAtendimento();
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
	
	private static void novoAtendimento(){
		System.out.println("Digite o nome da cliente:");
		Cliente cli = new Cliente(teclado.nextLine());
		
		System.out.println("Irá consumir um serviço ou um produto?"
				+ "\n1 - Serviço"
				+ "\n2 - Produto");
		
		int opcao = 0;
		try {
			opcao = Integer.parseInt(teclado.next());
		}catch(NumberFormatException e) {
			System.out.println("Não foi possível selecionar uma opção, tente novamente.");
			Utils.pausar(2);
			Teste.novoAtendimento();
		}
		
		if(opcao == 1) {
			System.out.println("Informe o profissional:");
			
		}
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