package br.com.cotiinformatica.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.ProdutoPostRequestDto;
import br.com.cotiinformatica.dtos.ProdutoPutRequestDto;
import br.com.cotiinformatica.entities.Produto;
import br.com.cotiinformatica.interfaces.IProdutoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {

	@Autowired
	private IProdutoService produtoService;

	@PostMapping
	public ResponseEntity<String> post(@RequestBody @Valid ProdutoPostRequestDto dto) {

		try {

			Produto produto = new Produto();
			Random random = new Random();

			produto.setIdProduto(random.nextInt(Integer.MAX_VALUE));
			produto.setNome(dto.getNome());
			produto.setDescricao(dto.getDescricao());
			produto.setPreco(dto.getPreco());
			produto.setQuantidade(dto.getQuantidade());

			produtoService.create(produto);

			return ResponseEntity.status(201).body("Produto cadastrado com sucesso.");
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

	@PutMapping
	public ResponseEntity<String> put(@RequestBody @Valid ProdutoPutRequestDto dto) {

		try {

			Produto produto = new Produto();

			produto.setIdProduto(dto.getIdProduto());
			produto.setNome(dto.getNome());
			produto.setDescricao(dto.getDescricao());
			produto.setPreco(dto.getPreco());
			produto.setQuantidade(dto.getQuantidade());

			produtoService.update(dto.getIdProduto(), produto);

			return ResponseEntity.status(200).body("Produto atualizado com sucesso.");

		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(400).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {

		try {

			Optional<Produto> produto = produtoService.findById(id);

			if (produto.isEmpty())
				return ResponseEntity.status(400).body("Produto não encontrado. Verifique o ID informado.");

			produtoService.delete(id);

			return ResponseEntity.status(200).body("Produto excluído com sucesso.");
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity<List<Produto>> getAll() throws Exception {

		try {

			List<Produto> produtos = produtoService.findAll();

			if (produtos.isEmpty())
				return ResponseEntity.status(204).body(null);

			return ResponseEntity.status(200).body(produtos);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
	}

	@GetMapping("{id}")
	public ResponseEntity<Optional<Produto>> getById(@PathVariable("id") Integer id) throws Exception {

		try {

			Optional<Produto> produto = produtoService.findById(id);

			if (produto.isEmpty())
				return ResponseEntity.status(204).body(null);

			return ResponseEntity.status(200).body(produto);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
	}
}
