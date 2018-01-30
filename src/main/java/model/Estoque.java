package model;

import java.util.HashMap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Estoque {
	HashMap<Long, Produto> itensEstoque;
	HashMap<Long, Produto> itensNaoListadosEstoque;

	public Estoque() {
		this.itensEstoque = new HashMap<Long, Produto>();
		this.itensNaoListadosEstoque = new HashMap<Long, Produto>();

	}

	public void adicionarProdutoEstoque(Produto produto) {
		this.itensEstoque.put(produto.getCodigoAuxiliar(), produto);
	}

	public void adicionarProdutoEstoqueNaoListado(Produto produto) {
		this.itensNaoListadosEstoque.put(produto.getCodigoAuxiliar(), produto);
	}

	public Produto consultarItemEstoque(long codigoAuxiliar) {
		return this.itensEstoque.get(codigoAuxiliar);
	}

	public Produto consultarItemNaoListadoEstoque(long codigoAuxiliar) {
		return this.itensNaoListadosEstoque.get(codigoAuxiliar);
	}

	public boolean produtoPresenteItensEstoque(long codigoAuxiliar) {
		return this.itensEstoque.containsValue(codigoAuxiliar);
	}

	public boolean produtoPresenteItensNaoListados(long codigoAuxiliar) {
		return this.itensNaoListadosEstoque.containsValue(codigoAuxiliar);
	}

}