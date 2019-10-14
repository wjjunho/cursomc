package com.nelioalves.cursomc.domain;

public enum EstadoPagamento {

    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private Integer valor;
    private String descricao;

    private EstadoPagamento(Integer valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static EstadoPagamento toEnum(Integer valor){

        if(valor == null)
            return null;

        for (EstadoPagamento estado : EstadoPagamento.values()){
            if (valor.equals(estado.getValor()))
                return estado;
        }
        throw new IllegalArgumentException("Id inválido: " + valor);
    }
}
