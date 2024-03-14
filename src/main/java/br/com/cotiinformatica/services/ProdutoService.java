package br.com.cotiinformatica.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.entities.Produto;
import br.com.cotiinformatica.interfaces.IProdutoRepository;
import br.com.cotiinformatica.interfaces.IProdutoService;

@Service
public class ProdutoService implements IProdutoService {

	@Autowired
	private IProdutoRepository iProdutoRepository;

	public Produto create(Produto produto) {
		return iProdutoRepository.save(produto);
	}

	public Produto update(Integer id, Produto produto) {

		if (iProdutoRepository.existsById(id)) {
			produto.setIdProduto(id);
			return iProdutoRepository.save(produto);
		} else
			throw new IllegalArgumentException("Produto não encontrado. Verifique o ID informado.");
	}

	public void delete(Integer id) {
		iProdutoRepository.deleteById(id);
	}

	// Type mismatch: cannot convert from Iterable<Produto> to List<Produto>
	public List<Produto> findAll() {
		Iterable<Produto> iterableProduto = iProdutoRepository.findAll();
		List<Produto> lista = new ArrayList<Produto>();
		iterableProduto.forEach(lista::add);
		return lista;
	}

	public Optional<Produto> findById(Integer id) {
		return iProdutoRepository.findById(id);
	}
}
