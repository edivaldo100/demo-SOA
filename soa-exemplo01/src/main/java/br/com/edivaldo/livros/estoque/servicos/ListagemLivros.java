package br.com.edivaldo.livros.estoque.servicos;

import java.util.List;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import br.com.edivaldo.livros.estoque.daos.LivroDAO;
import br.com.edivaldo.livros.estoque.modelos.Livro;


@WebService
public class ListagemLivros {

	
	public List<Livro> listarLivros() {
		LivroDAO livroDAO = obterDAO();
		return livroDAO.listarLivros();
	}
	
	private LivroDAO obterDAO() {
		return new LivroDAO();
	}

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/livros", new ListagemLivros());
		System.out.println("Serviço inicializado!");
	
	}

}
