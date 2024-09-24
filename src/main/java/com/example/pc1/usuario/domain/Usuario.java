package com.example.pc1.usuario.domain;

import com.example.pc1.kart.domain.Kart;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String nombreCompleto;

    private String direccion;

    private String correo;

    private String password;

    @OneToMany
    List<Kart> carritosList;



}
