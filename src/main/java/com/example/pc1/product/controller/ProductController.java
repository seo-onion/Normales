package com.example.pc1.product.controller;

import com.example.pc1.exceptions.ConflictException;
import com.example.pc1.exceptions.LocalNotFoundException;
import com.example.pc1.product.domain.Product;
import com.example.pc1.product.domain.ProductService;
import com.example.pc1.product.dto.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/{productoid}")
    public ResponseEntity<ProductResponseDto> getProducto(@PathVariable Long productoid) throws LocalNotFoundException {
        ProductResponseDto producto1 = productService.get(productoid);
        return ResponseEntity.ok().body(producto1);
    }

    @PostMapping
    public ResponseEntity<Void> agregarproducto(@RequestBody Product product) throws ConflictException {
        productService.agregar(product);
        return ResponseEntity.created(null).build();
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> listastock(){
        return ResponseEntity.ok().body(productService.stockpositivo(0));
    }

    @PatchMapping("/{productoid}")
    public ResponseEntity<ProductResponseDto> aumentarstock(@PathVariable Long productoid, @RequestParam Integer stock) throws LocalNotFoundException {
        ProductResponseDto product1 = productService.masStock(productoid,stock);
        return ResponseEntity.ok().body(product1);
    }
}
