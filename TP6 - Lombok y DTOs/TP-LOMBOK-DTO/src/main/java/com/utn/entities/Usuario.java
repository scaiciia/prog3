package com.utn.entities;

import com.utn.base.Base;
import com.utn.enums.Rol;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Usuario extends Base {

    private String nombre;
    private String apellido;

    @EqualsAndHashCode.Include
    private String mail;

    private String celular;

    @ToString.Exclude
    private String contraseña;

    private Rol rol;

    @Builder.Default
    @ToString.Exclude
    private Set<Pedido> pedidos = new HashSet<>();

    public void addPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }
}