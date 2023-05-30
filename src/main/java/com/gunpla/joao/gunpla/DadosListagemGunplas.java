package com.gunpla.joao.gunpla;

public record DadosListagemGunplas(String nome, Serie serie, String unidade, Modelo modelo, Marca marca) {
	
	public DadosListagemGunplas(Gunpla gunpla) {
		this(gunpla.getNome(),
			 gunpla.getSerie(),
			 gunpla.getUnidade(),
			 gunpla.getModelo(),
			 gunpla.getMarca());
	}
}
