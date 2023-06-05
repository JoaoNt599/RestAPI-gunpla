package com.gunpla.joao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gunpla.joao.gunpla.DadosAtualizarGunpla;
import com.gunpla.joao.gunpla.DadosCadastroGunpla;
import com.gunpla.joao.gunpla.DadosDetalhamentoGunpla;
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
	public ResponseEntity<DadosDetalhamentoGunpla> cadastrar(@RequestBody @Valid DadosCadastroGunpla dados, UriComponentsBuilder uriBuilder) {
		var gunpla = new Gunpla(dados);

		repository.save(gunpla);
		
		var uri = uriBuilder.path("/gunplas/{id}").buildAndExpand(gunpla.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosDetalhamentoGunpla(gunpla));
	}
	
	@GetMapping
	public ResponseEntity<List<DadosListagemGunplas>> listar(){
		var lista = repository.findAllByExistirTrue().stream().map(DadosListagemGunplas::new).toList();
		
		return ResponseEntity.ok(lista);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoGunpla> atualizar(@RequestBody @Valid DadosAtualizarGunpla dados) {
		var gunpla = repository.getReferenceById(dados.id());
		gunpla.atualizarInformacoes(dados);
		
		return ResponseEntity.ok(new DadosDetalhamentoGunpla(gunpla));
	}
	
	@PutMapping("/adicionar/{id}")
	@Transactional
	public ResponseEntity<Void> Adicionar(@PathVariable Long id) {
		var gunpla = repository.getReferenceById(id);
		gunpla.adicionar();
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		repository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("existir/{id}")
	@Transactional
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		var gunpla = repository.getReferenceById(id);
		gunpla.remover();
		
		return ResponseEntity.noContent().build();
	}
}
