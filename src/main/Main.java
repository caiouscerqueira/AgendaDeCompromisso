package main;

import java.util.GregorianCalendar;

import classes.Agenda;
import classes.Contato;
import classes.ContatoBasico;
import classes.EContato;
import classes.Telefone;

public class Main {
	static void mostraDados(ContatoBasico obj) {
		System.out.println(obj.getDados());
		if (obj instanceof Contato)
			System.out.println(((Contato) obj).getIdade());
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx");
	}

	public static void main(String[] args) {
		Agenda a;
		a = new Agenda();

		Contato cb;
		cb = new Contato("Teste", new GregorianCalendar(1980, 10, 28));
		cb.setTelefone(new Telefone("3333-5555", "Telefone residencial"));
		cb.setTelefone(new Telefone("99111-1111", "Telefone celular"));
		a.inserir(cb);

		a.inserir(
				new EContato("Exemplo", new GregorianCalendar(1975, 2, 22), "exemplo@gmail.com", "www.exemplo.com.br"));

		ContatoBasico obj = a.buscar("Teste"); // pesquisa por nome

		if (obj != null)
			mostraDados(obj);
		else
			System.out.println("Contato nao encontrado!");
	}
}