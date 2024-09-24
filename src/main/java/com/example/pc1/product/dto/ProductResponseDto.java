package com.example.pc1.product.dto;

import lombok.Data;

@Data
public class ProductResponseDto {
    private Long id;

    private String descripcion;

    private Double precio;

    private Integer stock;

}
