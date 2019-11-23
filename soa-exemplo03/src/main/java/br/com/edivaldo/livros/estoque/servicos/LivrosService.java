package br.com.edivaldo.livros.estoque.servicos;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;
import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.SOAPFaultException;

import br.com.edivaldo.livros.estoque.daos.LivroDAO;
import br.com.edivaldo.livros.estoque.modelos.Livro;
import br.com.edivaldo.livros.estoque.modelos.Usuario;

@WebService
public class LivrosService {

	@WebResult(name = "livro")
	public List<Livro> listarLivros() {
		LivroDAO livroDAO = obterDAO();
		return livroDAO.listarLivros();
	}

	@WebResult(name = "livro")
	public List<Livro> listarLivrosPaginacao(int numeroDaPagina, int tamanhoDaPagina) {
		LivroDAO livroDAO = obterDAO();

		return livroDAO.listarLivros(numeroDaPagina, tamanhoDaPagina);
	}

	public void criarLivro(@WebParam(name = "livro") Livro livro,
			@WebParam(name = "usuario", header = true) Usuario usuario)
			throws UsuarioNaoAutorizadoException, SOAPException {
		if (usuario.getLogin().equals("soa") && usuario.getSenha().equals("soa")) {
			obterDAO().criarLivro(livro);
		} else {
			throw new UsuarioNaoAutorizadoException("Não autorizado");
		}
	}

	private LivroDAO obterDAO() {
		return new LivroDAO();
	}

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/livros", new LivrosService());
		System.out.println("Serviço inicializado!");

	}

}
