package com.generation.LojaGames.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.generation.LojaGames.models.Produto;
import com.generation.LojaGames.repositories.ProdutoRepository;

@RestController
@RequestMapping("/api/v1/produtos")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repositorio;

	@GetMapping("/todos")
	public ResponseEntity<List<Produto>> pegarTodos() {
		List<Produto> objetoLista = repositorio.findAll();
		if (objetoLista.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(objetoLista);
		}
	}

	@GetMapping("/{id_produto}")
	public ResponseEntity<Produto> pegarPorId(@PathVariable(value = "id_produto") Long idProduto) {
		Optional<Produto> objetoOptional = repositorio.findById(idProduto);
		if (objetoOptional.isPresent()) {
			return ResponseEntity.status(200).body(objetoOptional.get());
		} else {
			return ResponseEntity.status(204).build();
		}
	}

	@GetMapping("/nome")
	public ResponseEntity<List<Produto>> GetByNomeProduto(@Valid @RequestBody String nomeProdutos) {
		return ResponseEntity.ok(repositorio.findAllByNomeProdutoContainingIgnoreCase(nomeProdutos));
	}

	@GetMapping("/preco")
	public ResponseEntity<List<Produto>> GetByPreco(@Valid @RequestBody Double preco) {
		return ResponseEntity.ok(repositorio.findAllByPreco(preco));
	}

	@GetMapping("/tipo")
	public ResponseEntity<List<Produto>> GetTipoProduto(@Valid @RequestBody String tipoProduto) {
		return ResponseEntity.ok(repositorio.findAllByTipoProdutoContainingIgnoreCase(tipoProduto));
	}

	@PostMapping("/salvar")
	public ResponseEntity<Produto> salvar(@Valid @RequestBody Produto novoProduto) {
		return ResponseEntity.status(201).body(repositorio.save(novoProduto));
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Produto> atualizar(@Valid @RequestBody Produto novoProduto) {
		return ResponseEntity.status(201).body(repositorio.save(novoProduto));
	}

	@DeleteMapping("/deletar/{id_produto}")
	public ResponseEntity<Produto> deletar(@PathVariable(value = "id_produto") Long idProduto) {
		Optional<Produto> objetoOptional = repositorio.findById(idProduto);
		if (objetoOptional.isPresent()) {
			repositorio.deleteById(idProduto);
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(400).build();
		}
	}
}
