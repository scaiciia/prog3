package com.utn.entities;

import com.utn.base.Base;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class Producto extends Base {

    private String nombre;
    private Double precio;
    private String descripcion;
    private int stock;
    private String imagen;
    private boolean disponible;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}
