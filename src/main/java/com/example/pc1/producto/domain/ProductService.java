package com.example.pc1.producto.domain;

import com.example.pc1.producto.infrastructure.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public void agregar(Product product){
        productRepository.save(product);
    }

    public List<Product> stockpositivo(){
        return productRepository.findByPrecioGreaterThan(0);
    }
}
