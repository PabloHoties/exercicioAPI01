package br.com.cotiinformatica.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.cotiinformatica.entities.Produto;

public interface IProdutoService {

	Produto create(Produto produto);

	public Produto update(Integer id, Produto produto);

	public void delete(Integer id);

	public List<Produto> findAll();

	public Optional<Produto> findById(Integer id);
}
