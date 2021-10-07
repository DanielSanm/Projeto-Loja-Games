<<<<<<< HEAD:src/main/java/com/generation/LojaGames/Repository/CategoriaRepository.java
package com.generation.LojaGames.Repository;
=======
package com.generation.LojaGames.repositories;
>>>>>>> af2844db5d6487e95fb4ad1dd11c01e636e85009:src/main/java/com/generation/LojaGames/repositories/CategoriaRepository.java

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.LojaGames.models.Categoria;

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
