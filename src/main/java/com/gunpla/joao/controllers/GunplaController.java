package com.gunpla.joao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gunpla.joao.gunpla.DadosCadastroGunpla;
import com.gunpla.joao.gunpla.Gunpla;
import com.gunpla.joao.gunpla.GunplaRepository;

@RestController
@RequestMapping("/gunplas")
public class GunplaController {

	@Autowired
	private GunplaRepository repository;
	
	@PostMapping
	public void cadastrar(@RequestBody DadosCadastroGunpla dados) {
		repository.save(new Gunpla(dados));
	}
}
