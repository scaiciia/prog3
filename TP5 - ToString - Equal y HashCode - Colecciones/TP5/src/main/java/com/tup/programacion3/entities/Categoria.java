package com.tup.programacion3.entities;

import com.tup.programacion3.base.Base;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Categoria extends Base {
    private String nombre;
    private String descripcion;
    private Set<Producto> productos = new HashSet<>();

    public Categoria(Long id, String nombre, String descripcion) {
        super(id);
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Producto> getProductos() {
        return this.productos;
    }

    public void addProducto(Producto producto) {
        this.productos.add(producto);
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }

        Categoria cat = (Categoria) o;
        return Objects.equals(nombre, cat.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nombre);
    }

    @Override
    public String toString() {
        return "Categoria{" + super.toString() +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' + '}';
    }
}
