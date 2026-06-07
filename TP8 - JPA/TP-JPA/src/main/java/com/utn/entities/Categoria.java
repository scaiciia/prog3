package com.utn.entities;

import com.utn.base.Base;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categoria")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class Categoria extends Base {
    private String nombre;

    private String descripcion;
}
