package com.generation.LojaGames.Controller;

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

import com.generation.LojaGames.Model.Produtos;
import com.generation.LojaGames.Repositories.ProdutosRepository;

@RestController
@RequestMapping("/api/v1/produtos")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ProdutosController {

	@Autowired
	private ProdutosRepository repositorio;

	@GetMapping("/todos")
	public ResponseEntity<List<Produtos>> pegarTodos() {
		List<Produtos> objetoLista = repositorio.findAll();

		if (objetoLista.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(objetoLista);
		}
	}

	@GetMapping("/{id_produto}")
	public ResponseEntity<Produtos> pegarPorId(@PathVariable(value = "id_produto") Long idProduto) {
		Optional<Produtos> objetoOptional = repositorio.findById(idProduto);

		if (objetoOptional.isPresent()) {
			return ResponseEntity.status(200).body(objetoOptional.get());
		} else {
			return ResponseEntity.status(204).build();
		}
	}

	@GetMapping("/nome")
	public ResponseEntity<List<Produtos>> GetByNomeProduto(@Valid @RequestBody String nomeProdutos) {
		return ResponseEntity.ok(repositorio.findAllByNomeProdutoContainingIgnoreCase(nomeProdutos));
	}

	@GetMapping("/preco")
	public ResponseEntity<List<Produtos>> GetByPreco(@Valid @RequestBody Double preco) {
		return ResponseEntity.ok(repositorio.findAllByPreco(preco));
	}

	@GetMapping("/tipo")
	public ResponseEntity<List<Produtos>> GetTipoProduto(@Valid @RequestBody String tipoProduto) {
		return ResponseEntity.ok(repositorio.findAllByTipoProdutoContainingIgnoreCase(tipoProduto));
	}

	@PostMapping("/salvar")
	public ResponseEntity<Produtos> salvar(@Valid @RequestBody Produtos novoProduto) {
		return ResponseEntity.status(201).body(repositorio.save(novoProduto));

	}

	@PutMapping("/atualizar")
	public ResponseEntity<Produtos> atualizar(@Valid @RequestBody Produtos novoProduto) {
		return ResponseEntity.status(201).body(repositorio.save(novoProduto));

	}

	@DeleteMapping("/deletar/{id_produto}")
	public ResponseEntity<Produtos> deletar(@PathVariable(value = "id_produto") Long idProduto) {
		Optional<Produtos> objetoOptional = repositorio.findById(idProduto);

		if (objetoOptional.isPresent()) {
			repositorio.deleteById(idProduto);
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(400).build();
		}
	}
}
