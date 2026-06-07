package com.utn.entities;

import com.utn.base.Base;
import com.utn.enums.Rol;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class Usuario extends Base {

    private String nombre;
    private String apellido;

    private String mail;

    private String celular;

    @ToString.Exclude
    private String contrasena;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "usuario_id")
    @Builder.Default
    private Set<Pedido> pedidos = new HashSet<>();

    public void addPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

}
