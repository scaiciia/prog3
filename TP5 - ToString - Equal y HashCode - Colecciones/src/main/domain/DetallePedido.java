package main.domain;

import java.util.Objects;

import main.domain.base.Base;

public class DetallePedido extends Base {

    private int cantidad;
    private Double subtotal;
    private Producto producto;

    public DetallePedido(Long id, int cantidad, Producto producto) {
        super(id);
        this.cantidad = cantidad;
        this.producto = producto;
        calcularSubtotal();
    }

    public void calcularSubtotal() {
        if (producto == null) {
            this.subtotal = 0.0;
            return;
        }

        this.subtotal = this.cantidad * producto.getPrecio();
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }

        DetallePedido detalle = (DetallePedido) o;
        return Objects.equals(producto, detalle.getProducto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), producto);
    }

    @Override
    public String toString() {
        return "DetallePedido{" +
                "producto=" + (producto != null ? producto.getNombre() : "null") +
                ", cantidad=" + cantidad +
                ", subtotal=$" + subtotal + '}';
    }

}
