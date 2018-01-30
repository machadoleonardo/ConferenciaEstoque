package controller;

import java.util.HashMap;

import model.Estoque;
import model.Produto;

public class GerenciadorEstoque {
	Estoque estoque;

	public GerenciadorEstoque() {
		this.estoque = new Estoque();
	}

	public void adicionarProduto(Produto produtoAtualizar) {
		HashMap<Long, Produto> estoqueTemporario = this.retornaEstoque(produtoAtualizar);
		if (estoqueTemporario != null) {
			Produto produto = estoqueTemporario.get(produtoAtualizar.getCodigoAuxiliar());
			if (produtoAtualizar.isAtualiza()) {
				estoqueTemporario.put(produtoAtualizar.getCodigoAuxiliar(), this.atualizaQuantidadeProduto(produto, produtoAtualizar.getQuantidadeEstoque()));
			} else {
				estoqueTemporario.put(produtoAtualizar.getCodigoAuxiliar(), this.adicionaQuantidadeProduto(produto, produtoAtualizar.getQuantidadeEstoque()));
			}
		} else {
			Produto produto = new Produto();
			produto.setCodigoAuxiliar(produtoAtualizar.getCodigoAuxiliar());
			produto.setQuantidadeEstoque(produtoAtualizar.getQuantidadeEstoque());
			this.estoque.adicionarProdutoEstoqueNaoListado(produto);
		}
	}

	private HashMap<Long, Produto> retornaEstoque(Produto produtoAtualizar) {
		HashMap<Long, Produto> estoqueTemporario = null;
		if (this.estoque.produtoPresenteItensEstoque(produtoAtualizar.getCodigoAuxiliar())) {
			estoqueTemporario = this.estoque.getItensEstoque();
		} else if (this.estoque.produtoPresenteItensNaoListados(produtoAtualizar.getCodigoAuxiliar())) {
			estoqueTemporario = this.estoque.getItensNaoListadosEstoque();
		}
		return estoqueTemporario;

	}

	public Produto atualizaQuantidadeProduto(Produto produto, int quantidadeEstoque) {
		produto.setQuantidadeEstoque(quantidadeEstoque);
		return produto;
	}

	public Produto adicionaQuantidadeProduto(Produto produto, int quantidadeEstoque) {
		produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + quantidadeEstoque);
		return produto;
	}

}
