package com.utn.entities;

import com.utn.base.Base;
import com.utn.enums.Estado;
import com.utn.enums.FormaPago;
import com.utn.interfaces.Calculable;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.action.internal.OrphanRemovalAction;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class Pedido extends Base implements Calculable {

    private LocalDate fecha = LocalDate.now();

    @Enumerated(EnumType.STRING)
    private Estado estado = Estado.PENDIENTE;

    private Double total = 0.0;

    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pedido_id")
    @Builder.Default
    private Set<DetallePedido> detalles = new HashSet<>();

    public void addDetallePedido(int cantidad, Producto producto) {
        DetallePedido detalle = DetallePedido.builder()
                .cantidad(cantidad)
                .producto(producto)
                .build();
        detalle.calcularSubtotal();
        this.detalles.add(detalle);
    }

    @Override
    public void calcularTotal() {
        this.total = detalles.stream()
                .mapToDouble(DetallePedido::getSubtotal)
                .sum();
    }

}
