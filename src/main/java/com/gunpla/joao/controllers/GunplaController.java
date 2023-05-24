package com.gunpla.joao.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gunpla.joao.gunpla.DadosCadastroGunpla;

@RestController
@RequestMapping("/gunplas")
public class GunplaController {

	@PostMapping
	public void cadastrar(@RequestBody DadosCadastroGunpla dados) {
		
		System.out.println(dados);
	}
}
