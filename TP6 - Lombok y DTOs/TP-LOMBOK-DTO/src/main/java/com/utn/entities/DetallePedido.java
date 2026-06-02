package com.utn.entities;

import com.utn.base.Base;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@SuperBuilder
public class DetallePedido extends Base {

    private int cantidad;
    private Double subtotal;

    @EqualsAndHashCode.Include
    private Producto producto;

    public void calcularSubtotal() {
        if (producto == null) {
            this.subtotal = 0.0;
            return;
        }

        this.subtotal = this.cantidad * producto.getPrecio();
    }

}
