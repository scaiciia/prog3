package com.tup.programacion3.entities;

import com.tup.programacion3.base.Base;
import com.tup.programacion3.enums.Estado;
import com.tup.programacion3.enums.FormaPago;
import com.tup.programacion3.interfaces.Calculable;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Pedido extends Base implements Calculable {
    private LocalDate fecha;
    private Estado estado;
    private Double total;
    private FormaPago formaPago;
    private Set<DetallePedido> detalles = new HashSet<>();

    public Pedido(Long id, FormaPago formaPago) {
        super(id);
        this.fecha = LocalDate.now();
        this.estado = Estado.PENDIENTE;
        this.formaPago = formaPago;
        this.total = 0.0;
    }

    @Override
    public void calcularTotal() {
        this.total = 0.0;
        for (DetallePedido detalle: this.detalles) {
            this.total += detalle.getSubtotal();
        }
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public void addDetallePedido(int cantidad, Producto producto) {
        Long detalleId = (long) (detalles.size() + 1);
        DetallePedido nuevoDetalle = new DetallePedido(detalleId, cantidad, producto);
        detalles.add(nuevoDetalle);
        calcularTotal();
    }

    public DetallePedido findeDetallePedidoByProducto(Producto producto) {
        for (DetallePedido detalle: this.detalles) {
            if (detalle.getProducto().equals(producto)) {
                return detalle;
            }
        }

        return null;
    }

    public void deleteDetallePedidoByProducto(Producto producto) {
        DetallePedido aEliminar = findeDetallePedidoByProducto(producto);
        if (aEliminar != null) {
            detalles.remove(aEliminar);
            calcularTotal();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }

        Pedido pedido = (Pedido) o;
        return Objects.equals(fecha, pedido.getFecha());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fecha);
    }

    @Override
    public String toString() {
        return "Pedido{" + super.toString() +
                ", fecha=" + fecha +
                ", estado=" + estado +
                ", formaPago=" + formaPago +
                ", total=$" + total +
                ", detalles=" + detalles + '}';
    }
}
