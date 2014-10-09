package br.com.caelum.online.loja.controlador;

import java.util.List;

import br.com.caelum.online.loja.dominio.Produto;
import br.com.caelum.online.loja.repositorio.RepositorioDeProdutos;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.caelum.vraptor.validator.Validations;

@Resource
public class ProdutoController {

	private final RepositorioDeProdutos produtos;
	private final Validator validator;

	public ProdutoController(RepositorioDeProdutos produtos, Validator validator) {
		
		this.produtos = produtos;
		this.validator = validator;
	}
	
	public void formulario() {
		
	}
	
	@Post
	public void adiciona(final Produto produto) {
		
		/*
		if(produto.getPreco() < 0.1) {
			validator.add(new ValidationMessage("O preço deve ser maior que R$ 0.1", "preco"));
		}
		*/
		/*
		if(produto.getPreco() < 0.1) {
			validator.add(new I18nMessage("preco", "produto.preco.invalido"));
		}
		*/

		validator.checking(new Validations() {
			{
				that(produto.getPreco() > 0.1, "erro", "produto.preco.invalido");
				
				String descricao = produto.getDescricao().trim();
				that(descricao.length() > 0, "erro", "produto.descricao.vazio");
				
				String nome = produto.getNome().trim();
				that(nome.length() > 2 && nome.length() < 101, "erro", "produto.nome.ncaracter");
			}
		});
		
		validator.onErrorUsePageOf(ProdutoController.class).formulario();
		
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
