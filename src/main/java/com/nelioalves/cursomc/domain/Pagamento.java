package com.nelioalves.cursomc.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToOne;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private EstadoPagamento estado;

    @OneToOne
    private Pedido pedido;

    public Pagamento() {
    }

    public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
        this.id = id;
        this.estado = estado;
        this.pedido = pedido;
    }
}
