package com.utn.dtos;

import com.utn.entities.Usuario;

public record UsuarioDTO(
    Long id,
    String nombre,
    String apellido,
    String mail,
    String celular,
    int cantidadPedidos
) {

    public static UsuarioDTO fromEntity(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getMail(),
                usuario.getCelular(),
                usuario.getPedidos().size()
        );
    }

}
