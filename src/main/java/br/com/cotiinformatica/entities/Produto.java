package br.com.cotiinformatica.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@Column(name = "id_produto")
	private Integer idProduto;

	@Column(name = "nome", length = 150, nullable = false)
	private String nome;

	@Column(name = "descricao", length = 1000, nullable = false)
	private String descricao;

	@Column(name = "quantidade")
	private Integer quantidade;

	@Column(name = "preco")
	private Double preco;
}
