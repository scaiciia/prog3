package com.utn.entities;

import com.utn.base.Base;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "detalle_pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class DetallePedido extends Base {

    private int cantidad;
    private Double subtotal;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    public void calcularSubtotal() {
        if (producto == null) {
            this.subtotal = 0.0;
            return;
        }

        this.subtotal = this.cantidad * producto.getPrecio();
    }

}
