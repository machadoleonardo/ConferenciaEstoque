package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto {
	private long codigoProduto;
	private String descricaoProduto;
	private long codigoAuxiliar;
	private int quantidadeEstoque;
	private int quantidadeMinima;
	private int quantidadeMaxima;
	private boolean atualiza;

	public Produto() {
		this.atualiza = true;
	}

}
