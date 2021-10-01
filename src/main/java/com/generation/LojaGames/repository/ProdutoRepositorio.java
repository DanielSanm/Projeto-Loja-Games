package com.generation.LojaGames.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.LojaGames.Model.Produtos;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produtos, Long> {

	/**
	 * Metodo utilizado para retornar pesquisa pela coluna descricaoTitulo
	 * 
	 * @param descricaoTitulo
	 * @return Lista com todos as descriçoes que contenham a palavra digitada
	 * @author Gustavo
	 * @since 1.0
	 */
	// public List<Produtos> findAllByContainingIgnoreCase(String descricaoTitulo);

	/**
	 * Metodo utilizado para retornar pesquisa pela coluna nomeProdutos
	 * 
	 * @param nomeProdutos
	 * @return Lista com todos os produtos
	 * @author Abner
	 * @since 1.0
	 */
	// public List<Produtos> findAll(Long nomeProdutos);

	/**
	 * Metodo utilizado para retornar pesquisa pela coluna IdProduto
	 * 
	 * @param IdProduto
	 * @return Optional com o produto do id inserido
	 * @author Abner
	 * @since 1.0
	 */
	public Optional<Produtos> findById(Long idProduto);

	/**
	 * Metodo utilizado para retornar pesquisa pela coluna nomeProdutos
	 * 
	 * @param nomeProdutos
	 * @return Lista com nome dos produtos
	 * @author Abner
	 * @since 1.0
	 */

	public List<Produtos> findByNomeProdutosContainingIgnoreCase(String nomeProdutos);

	/**
	 * Metodo utilizado para retornar pesquisa pela coluna tipoProduto
	 * 
	 * @param tipoProduto
	 * @return Lista com o produto por tipos
	 * @author Abner
	 * @since 1.0
	 */
	public List<Produtos> findBytipoProduto(String tipoProduto);
}
