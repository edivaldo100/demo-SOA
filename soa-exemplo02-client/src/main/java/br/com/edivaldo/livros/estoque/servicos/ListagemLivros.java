
package br.com.edivaldo.livros.estoque.servicos;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ListagemLivros", targetNamespace = "http://servicos.estoque.knight.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ListagemLivros {


    /**
     * 
     * @return
     *     returns java.util.List<br.com.edivaldo.livros.estoque.servicos.Livro>
     */
    @WebMethod
    @WebResult(name = "livro", targetNamespace = "")
    @RequestWrapper(localName = "listarLivros", targetNamespace = "http://servicos.estoque.knight.com/", className = "br.com.edivaldo.livros.estoque.servicos.ListarLivros")
    @ResponseWrapper(localName = "listarLivrosResponse", targetNamespace = "http://servicos.estoque.knight.com/", className = "br.com.edivaldo.livros.estoque.servicos.ListarLivrosResponse")
    @Action(input = "http://servicos.estoque.knight.com/ListagemLivros/listarLivrosRequest", output = "http://servicos.estoque.knight.com/ListagemLivros/listarLivrosResponse")
    public List<Livro> listarLivros();

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<br.com.edivaldo.livros.estoque.servicos.Livro>
     */
    @WebMethod
    @WebResult(name = "livro", targetNamespace = "")
    @RequestWrapper(localName = "listarLivrosPaginacao", targetNamespace = "http://servicos.estoque.knight.com/", className = "br.com.edivaldo.livros.estoque.servicos.ListarLivrosPaginacao")
    @ResponseWrapper(localName = "listarLivrosPaginacaoResponse", targetNamespace = "http://servicos.estoque.knight.com/", className = "br.com.edivaldo.livros.estoque.servicos.ListarLivrosPaginacaoResponse")
    @Action(input = "http://servicos.estoque.knight.com/ListagemLivros/listarLivrosPaginacaoRequest", output = "http://servicos.estoque.knight.com/ListagemLivros/listarLivrosPaginacaoResponse")
    public List<Livro> listarLivrosPaginacao(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1);

}
