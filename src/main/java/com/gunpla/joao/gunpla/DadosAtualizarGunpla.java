package com.gunpla.joao.gunpla;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarGunpla(
		
		@NotNull
		Long id, 
		String nome,
		Modelo modelo, 
		Marca marca) {
}
