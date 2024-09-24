package com.example.pc1.usuario.dtos;

import lombok.Data;

@Data
public class UserUpdateDto {
    private String nombreCompleto;

    private String direccion;

    private String correo;

    private String password;
}
