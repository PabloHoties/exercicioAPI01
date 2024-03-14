package br.com.cotiinformatica.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProdutoPutRequestDto {

	@NotNull
	private Integer idProduto;
	
	@Size(min = 3, max = 150)
	@NotBlank
	private String nome;
	
	@Size(min = 10, max = 1000)
	@NotBlank
	private String descricao;
	
	@NotNull
	private Double preco;
	
	@NotNull
	private Integer quantidade;
}