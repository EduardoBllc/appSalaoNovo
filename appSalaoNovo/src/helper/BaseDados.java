package helper;

import java.util.ArrayList;
import java.util.List;

import model.Profissional;
import model.Servico;

public class BaseDados {

	static List<Profissional> pro = new ArrayList<>();
	static List<Servico> serv = new ArrayList<>();

	public BaseDados() {
		
		pro.add(new Profissional("Duda"));	
		pro.add(new Profissional("Aline"));
		pro.add(new Profissional("Vaninha"));
		pro.add(new Profissional("Gabi"));
		pro.add(new Profissional("Geovana"));	
		
		serv.add(new Servico("Corte",60.0));
		serv.add(new Servico("Maquiagem",100.0));
		serv.add(new Servico("Design de sobrancelha",30.0));
		serv.add(new Servico("Extensão de cílios",100.0));
		serv.add(new Servico("Pintura de cabelo"));
		serv.add(new Servico("Cabelo colorido"));
		serv.add(new Servico("Micropigmentação"));
		serv.add(new Servico("Escova",60.0));
		
		pro.get(0).addListaServ(serv.get(1));
		pro.get(0).addListaServ(serv.get(2));
		pro.get(0).addListaServ(serv.get(3));
		pro.get(0).addListaServ(serv.get(5));
		
		pro.get(1).addListaServ(serv.get(3));
		pro.get(1).addListaServ(serv.get(6));
		
		pro.get(2).addListaServ(serv.get(0));
		pro.get(2).addListaServ(serv.get(4));
		pro.get(2).addListaServ(serv.get(7));
		
		pro.get(3).addListaServ(serv.get(0));
		pro.get(3).addListaServ(serv.get(4));
		pro.get(3).addListaServ(serv.get(7));
		
		pro.get(4).addListaServ(serv.get(1));

	}
	
	public List<Profissional> getPro() {
		return BaseDados.pro;
	}
	
	public List<Servico> getServ() {
		return BaseDados.serv;
	}
}
