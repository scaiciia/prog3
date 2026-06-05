package ar.edu.tup.programacion3.entities;

import ar.edu.tup.programacion3.enums.Estado;
import ar.edu.tup.programacion3.enums.FormaPago;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Pedido extends Base implements Calculable {

    @Builder.Default
    @EqualsAndHashCode.Include
    private LocalDate fecha = LocalDate.now();

    @Builder.Default
    private Estado estado = Estado.PENDIENTE;

    @Builder.Default
    private Double total = 0.0;

    @EqualsAndHashCode.Include
    private FormaPago formaPago;

    @Builder.Default
    private Set<DetallePedido> detalles = new HashSet<>();

    @Override
    public void calcularTotal() {
        this.total = detalles.stream()
                .mapToDouble(DetallePedido::getSubtotal)
                .sum();
    }

    public void addDetallePedido(int cantidad, Producto producto) {
        long detalleId = detalles.size() + 1L;
        DetallePedido detalle = DetallePedido.builder()
                .id(detalleId)
                .cantidad(cantidad)
                .producto(producto)
                .build();
        detalle.calcularSubtotal();
        detalles.add(detalle);
        calcularTotal();
    }

    public DetallePedido findeDetallePedidoByProducto(Producto producto) {
        return detalles.stream()
                .filter(d -> d.getProducto().equals(producto))
                .findFirst()
                .orElse(null);
    }

    public void deleteDetallePedidoByProducto(Producto producto) {
        DetallePedido aEliminar = findeDetallePedidoByProducto(producto);
        if (aEliminar != null) {
            detalles.remove(aEliminar);
            calcularTotal();
        }
    }


}
