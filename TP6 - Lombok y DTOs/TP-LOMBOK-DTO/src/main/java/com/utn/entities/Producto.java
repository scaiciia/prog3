package com.utn.entities;

import com.utn.base.Base;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@SuperBuilder
public class Producto extends Base {

    @EqualsAndHashCode.Include
    private String nombre;

    private Double precio;
    private String descripcion;
    private int stock;
    private String imagen;
    private boolean disponible;

}
