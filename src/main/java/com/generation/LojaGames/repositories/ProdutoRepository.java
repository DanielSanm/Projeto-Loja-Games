package com.generation.LojaGames.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.LojaGames.models.Produto;

@Repository

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	/**
	 * Metodo utilizado para retornar pesquisa pela coluna tipoProduto
	 * 
	 * @param descricaoTitulo
	 * @return Lista com todos os tipos de Produtos que contenham a palavra digitada
	 * @author Gustavo
	 * @since 1.0
	 */
	public List<Produto> findAllByTipoProdutoContainingIgnoreCase(String tipoProduto);

	/**
	 * Metodo utilizado para retornar pesquisa pela coluna NomeProduto
	 * 
	 * @param nomeProduto
	 * @return Lista com todos os nomes de produtos que contenham a palavra digitada
	 * @author Gustavo
	 * @since 1.0
	 */
	public List<Produto> findAllByNomeProdutoContainingIgnoreCase(String nomeProduto);

	/**
	 * Metodo utilizado para retornar pesquisa pela coluna Preço
	 * 
	 * @param preco
	 * @return Lista com todos os precos de produtos que contenham a palavra
	 *         digitada
	 * @author Gustavo
	 * @since 1.0
	 */
	public List<Produto> findAllByPreco(Double preco);
}
