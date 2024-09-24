package com.example.pc1.producto.controller;

import com.example.pc1.producto.domain.Product;
import com.example.pc1.producto.domain.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<Void> agregarproducto(@RequestBody Product product){
        productService.agregar(product);
        return ResponseEntity.created(null).build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> listastock(){
        return ResponseEntity.ok().body(productService.stockpositivo());
    }
}
