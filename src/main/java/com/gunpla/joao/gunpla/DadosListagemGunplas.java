package com.gunpla.joao.gunpla;

public record DadosListagemGunplas(Long id, String nome, Serie serie, String unidade, Modelo modelo, Marca marca) {
	
	public DadosListagemGunplas(Gunpla gunpla) {
		this(gunpla.getId(),
			 gunpla.getNome(),
			 gunpla.getSerie(),
			 gunpla.getUnidade(),
			 gunpla.getModelo(),
			 gunpla.getMarca());
	}
}
