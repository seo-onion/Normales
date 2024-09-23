package com.example.pc1.usuario.dtos;

import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;

    private String username;

    private String nombreCompleto;

    private String direccion;

    private String correo;
}
