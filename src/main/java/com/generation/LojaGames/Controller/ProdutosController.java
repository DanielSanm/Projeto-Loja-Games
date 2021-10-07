
package com.generation.LojaGames.Controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.LojaGames.Model.Produtos;
import com.generation.LojaGames.Repository.ProdutoRepositorio;

@RestController
@RequestMapping("/api/v1/produtos")
@CrossOrigin("*")
public class ProdutosController {

	@Autowired
	private ProdutoRepositorio repositorio;

	@GetMapping("/{id_produto}")

	public ResponseEntity<Produtos> GetById(@PathVariable(value = "id_produto") Long idProduto) {
		Optional<Produtos> optional = repositorio.findById(idProduto);

		if (optional.isPresent()) {
			return ResponseEntity.status(200).body(optional.get());
		} else {
			return ResponseEntity.status(204).build();
		}
	}

	@PostMapping("/salvar")
	public ResponseEntity<Produtos> salvar(@RequestBody Produtos produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repositorio.save(produto));
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Produtos> atualizar(@Valid @RequestBody Produtos novoProduto) {
		return ResponseEntity.status(200).body(repositorio.save(novoProduto));
	}

	@DeleteMapping("/deletar")
	public ResponseEntity<Produtos> deletar(@PathVariable(value = "id_produto") Long IdPostagem) {
		Optional<Produtos> optional = repositorio.findById(IdPostagem);

		if (optional.isPresent()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(400).build();

		}

	}
}
