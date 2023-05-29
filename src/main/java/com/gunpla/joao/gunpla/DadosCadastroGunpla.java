package com.gunpla.joao.gunpla;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroGunpla(
		
		@NotNull
		@NotBlank
		String nome,
		
		@Enumerated
		Serie serie,
		
		@NotBlank
		String unidade,
		
		@NotNull
		int quantidade,
		
		@Enumerated
		Modelo modelo,
		
		@Enumerated
		Marca marca) {
}
