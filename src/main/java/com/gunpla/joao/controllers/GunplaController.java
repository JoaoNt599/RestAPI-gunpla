package com.gunpla.joao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gunpla.joao.gunpla.DadosAtualizarGunpla;
import com.gunpla.joao.gunpla.DadosCadastroGunpla;
import com.gunpla.joao.gunpla.DadosListagemGunplas;
import com.gunpla.joao.gunpla.Gunpla;
import com.gunpla.joao.gunpla.GunplaRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/gunplas")
public class GunplaController {

	@Autowired
	private GunplaRepository repository;
	
	@PostMapping
	@Transactional //realiza rollback
	public void cadastrar(@RequestBody @Valid DadosCadastroGunpla dados) {
		repository.save(new Gunpla(dados));
	}
	
	@GetMapping
	public List<DadosListagemGunplas> listar(){
		return repository.findAllByExistirTrue().stream().map(DadosListagemGunplas::new).toList();
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizarGunpla dados) {
		var gunpla = repository.getReferenceById(dados.id());
		gunpla.atualizarInformacoes(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@DeleteMapping("existir/{id}")
	@Transactional
	public void remover(@PathVariable Long id) {
		var gunpla = repository.getReferenceById(id);
		gunpla.remover();
	}
	
	@PutMapping("/adicionar/{id}")
	@Transactional
	public void Adicionar(@PathVariable Long id) {
		var gunpla = repository.getReferenceById(id);
		gunpla.adicionar();
	}
}
