package com.generation.LojaGames.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Id Long idCategoria;

	@NotBlank
	private String nomeCategoria;

	@NotBlank
	private String setor;

	@OneToMany(mappedBy = "categoriaRelacionada", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"categoriaRelacionada"})
	private List<Produtos> produtos = new ArrayList<>();
	
	
	
	
	
	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

}
