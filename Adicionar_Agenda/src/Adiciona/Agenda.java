package Adiciona;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Agenda {
	private String nome;
	private GregorianCalendar calendario;
	private ArrayList<GregorianCalendar> agenda;
	private ArrayList<String> descricao;
	
	public Agenda(String nome_a) {
		this.nome = nome_a;
		agenda = new ArrayList<GregorianCalendar>(365);
		descricao = new ArrayList<String>(365);
	}
	
	public void adicionar(int ano_a,int mes_a,int dia_a, String descricao_a) {
		calendario = new GregorianCalendar(ano_a,mes_a,dia_a);
		agenda.add(calendario);
		descricao.add(descricao_a);
	}
	
	public GregorianCalendar getCalendario() {
		return calendario;
	}
	
	public void exibeCalendario() {
		for(int i = 0; i < agenda.size(); i++) {
			int mes_calendario = agenda.get(i).get(Calendar.MONTH) + 1;
			System.out.println("Data: " + agenda.get(i).get(Calendar.DAY_OF_MONTH) + "/" + mes_calendario  + "/" + agenda.get(i).get(Calendar.YEAR));
			System.out.println("Descrição: " + descricao.get(i));
		}
	}
	
	public String getNome() {
		return nome;
	}
}