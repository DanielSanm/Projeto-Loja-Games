package com.generation.LojaGames.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_produtos")
public class Produtos {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Id Long idProduto;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private Double preco;
	
	@NotBlank
	private String tipoProduto;
	
	private Long fk_categoria;
	
	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public Long getFk_categoria() {
		return fk_categoria;
	}

	public void setFk_categoria(Long fk_categoria) {
		this.fk_categoria = fk_categoria;
	}

}
