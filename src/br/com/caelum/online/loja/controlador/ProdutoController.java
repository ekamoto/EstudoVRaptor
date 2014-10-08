package br.com.caelum.online.loja.controlador;

import java.util.List;

import br.com.caelum.online.loja.dominio.Produto;
import br.com.caelum.online.loja.repositorio.RepositorioDeProdutos;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;

@Resource
public class ProdutoController {

	private RepositorioDeProdutos produtos;

	public ProdutoController(RepositorioDeProdutos produtos) {
		
		this.produtos = produtos;
	}
	
	public void formulario() {
		
	}
	
	@Post
	public void adiciona(Produto produto) {
		
		produtos.salva(produto);
	}
	
	public List<Produto> lista() {
		
		return produtos.pegaTodos();
	}
	
	@Path("/produto/{id}")
	public Produto exibe(Long id) {
		
		return produtos.pegaPorId(id);
	}

}
