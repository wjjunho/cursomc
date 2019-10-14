package com.nelioalves.cursomc.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
public class Pedido implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Date instante;

    @OneToOne
    private Pagamento pagamento;

    private Cliente cliente;

    private Endereco enderecoEntrega;

    public Pedido() {
    }

    public Pedido(Integer id, Date instante, Pagamento pagamento, Cliente cliente, Endereco enderecoEntrega) {
        this.id = id;
        this.instante = instante;
        this.pagamento = pagamento;
        this.cliente = cliente;
        this.enderecoEntrega = enderecoEntrega;
    }
}
