package com.example.pc1.producto.domain;

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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String descripcion;

    private Double precio;

    private Integer stock;

    @ManyToMany
    private List<Kart> carritosList;

}
