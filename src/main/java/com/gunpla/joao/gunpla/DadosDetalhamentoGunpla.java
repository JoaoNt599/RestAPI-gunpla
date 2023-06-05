package com.gunpla.joao.gunpla;

public record DadosDetalhamentoGunpla(
		Long  id,
		String nome,
		Serie serie,
		String unidade,
		int quantidade,
		Modelo modelo,
		Marca marca,
		Boolean existe) {
	
	public DadosDetalhamentoGunpla(Gunpla gunpla) {
		this(gunpla.getId(),
			  gunpla.getNome(),
			  gunpla.getSerie(),
			  gunpla.getUnidade(),
			  gunpla.getQuantidade(),
			  gunpla.getModelo(),
			  gunpla.getMarca(),
			  gunpla.getExiste());
	}
}
