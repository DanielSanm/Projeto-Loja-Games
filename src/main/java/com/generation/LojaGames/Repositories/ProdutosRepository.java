package com.generation.LojaGames.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.LojaGames.Model.Produtos;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

	/**
	 * Metodo utilizado para retornar pesquisa pela coluna tipoProduto
	 * 
	 * @param descricaoTitulo
	 * @return Lista com todos os tipos de Produtos que contenham a palavra digitada
	 * @author Abner
	 * @since 1.0
	 */
	public List<Produtos> findAllByTipoProdutoContainingIgnoreCase(String tipoProduto);

	/**
	 * Metodo utilizado para retornar pesquisa pela coluna NomeProduto
	 * 
	 * @param nomeProduto
	 * @return Lista com todos os nomes de produtos que contenham a palavra digitada
	 * @author Abner
	 * @since 1.0
	 */
	public List<Produtos> findAllByNomeProdutoContainingIgnoreCase(String nomeProduto);
	
	/**
	 * Metodo utilizado para retornar pesquisa pela coluna Preço
	 * 
	 * @param preco
	 * @return Lista com todos os precos de produtos que contenham a palavra digitada
	 * @author Gustavo
	 * @since 1.0
	 */
	public List<Produtos> findAllByPreco(Double preco);
}
