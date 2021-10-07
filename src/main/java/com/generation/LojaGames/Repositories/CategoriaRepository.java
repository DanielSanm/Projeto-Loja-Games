package com.generation.LojaGames.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.LojaGames.Model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	/**
	 * Busca todas as categorias a a partir da Descriçao
	 * 
	 * @param descricaoCategoria
	 * @return Lista com todos as descriçoes que contenham a palavra digitada
	 * @author Gustavo
	 * @since 1.0
	 */
	public List<Categoria> findAllByDescricaoCategoriaContainingIgnoreCase(String descricaoCategoria);

	/**
	 * Busca todas as categorias a a partir do Nome da Categoria
	 * 
	 * @param nomeCategoria
	 * @return Lista com todos as descriçoes que contenham a palavra digitada
	 * @author Gustavo
	 * @since 1.0
	 */
	public List<Categoria> findAllByNomeCategoriaContainingIgnoreCase(String nomeCategoria);

}
