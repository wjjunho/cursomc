package com.nelioalves.cursomc.domain.enuns;

public enum TipoCliente {
	
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Juridica");
	
	private int valor;
	private String descricao;
	
	private TipoCliente(Integer valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public int getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum(Integer valor) {
		
		if(valor == null)
			return null;
		
		for(TipoCliente tc:TipoCliente.values()) {
			if (tc.getValor() == valor)
				return tc;
		}
		
		throw new IllegalArgumentException("Id invalido!" + valor);
	}

}
