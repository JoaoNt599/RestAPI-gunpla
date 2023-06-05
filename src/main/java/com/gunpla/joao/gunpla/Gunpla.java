package com.gunpla.joao.gunpla;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Entity(name = "gunpla")
@Table(name = "tb_gunplas")
public class Gunpla {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private Serie serie;
	
	private String unidade;
	private int quantidade;
	
	@Enumerated(EnumType.STRING)
	private Modelo modelo;
	
	@Enumerated(EnumType.STRING)
	private Marca marca;
	
	private Boolean existe;
	
	public Gunpla() {
		
	}

	public Gunpla(Long id, String nome, Serie serie, String unidade, int quantidade, Modelo modelo, Marca marca) {
		super();
		this.id = id;
		this.nome = nome;
		this.serie = serie;
		this.unidade = unidade;
		this.quantidade = quantidade;
		this.modelo = modelo;
		this.marca = marca;
	}

	public Gunpla(DadosCadastroGunpla dados) {
		this.setExiste(true);
		this.nome=dados.nome();
		this.serie=dados.serie();
		this.unidade=dados.unidade();
		this.quantidade=dados.quantidade();
		this.modelo=dados.modelo();
		this.marca=dados.marca();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Boolean getExiste() {
		return existe;
	}

	public void setExiste(Boolean existe) {
		this.existe = existe;
	} 
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gunpla other = (Gunpla) obj;
		return Objects.equals(id, other.id);
	}

	public void atualizarInformacoes(@Valid DadosAtualizarGunpla dados) {
		
		if (dados.nome() != null) {
			this.nome = dados.nome();
		}
		if (dados.modelo() != null) {
			this.modelo = dados.modelo();
		}
		if (dados.marca() != null) {
			this.marca = dados.marca();
		}
	}

	public void remover() {
		this.existe = false;
	}

	public void adicionar() {
		this.existe = true;
	}
}
