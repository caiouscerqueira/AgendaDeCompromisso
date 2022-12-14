package classes;

import java.util.ArrayList;

public class Agenda {
	private ArrayList<ContatoBasico> contatos;

	public Agenda() {
		contatos = new ArrayList<ContatoBasico>();
	}

	public void inserir(ContatoBasico c) {
		contatos.add(c);
	}

	public ContatoBasico buscar(String nome) {
		for (int i = 0; i < contatos.size(); i++) {
			ContatoBasico c = contatos.get(i);
			if (c.getNome().equalsIgnoreCase(nome))
				return contatos.get(i);
		}
		return null;
	}

	public ContatoBasico buscar(int posicao) {
		if (posicao >= 0 && posicao < contatos.size()) {
			return contatos.get(posicao);
		}
		return null;
	}

	public EContato buscarEmail(String email) {
		for (int i = 0; i < contatos.size(); i++) {
			if (contatos.get(i) instanceof EContato) {
				EContato c = (EContato) contatos.get(i);
				if (c.getEmail().equalsIgnoreCase(email))
					return (EContato) contatos.get(i);
			}
		}
		return null;
	}

	public Contato[]

			buscarGeral(String palavraChave) {
		ArrayList<ContatoBasico> todos = new ArrayList<ContatoBasico>();
		for (int i = 0; i < contatos.size(); i++) {
			ContatoBasico c = contatos.get(i);
			if (c.getDados().contains(palavraChave))
				todos.add(c);
		}
		Contato[] vet = new Contato[todos.size()];

		return (todos.toArray(vet));
	}

	public Contato[]

			buscarTodos() {
		Contato[] vet = new Contato[contatos.size()];

		return (contatos.toArray(vet));
	}

	public int getQuantidade() {
		return contatos.size();
	}
}