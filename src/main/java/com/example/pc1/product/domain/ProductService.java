package com.example.pc1.product.domain;

import com.example.pc1.exceptions.ConflictException;
import com.example.pc1.exceptions.LocalNotFoundException;
import com.example.pc1.product.dto.ProductResponseDto;
import com.example.pc1.product.infrastructure.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ModelMapper modelMapper;

    public ProductResponseDto get(Long id) throws LocalNotFoundException{
        Optional<Product> product1 = productRepository.findById(id);
        if (product1.isEmpty()){
            throw new LocalNotFoundException();
        }
        return modelMapper.map(product1.get(),ProductResponseDto.class);
    }

    public void agregar(Product product) throws ConflictException{
        List<Product> p1 = productRepository.findAll();
        for (Product product1: p1){
            Product product2 = new Product();
            product2.setDescripcion(product1.getDescripcion());
            product2.setPrecio(product1.getPrecio());
            product2.setStock(product1.getStock());
            if(product1.getDescripcion() == product2.getDescripcion() || product1.getStock() == product2.getStock() || product1.getPrecio() == product1.getPrecio()){
                throw new ConflictException();
            }
        }
        productRepository.save(product);
    }

    public List<ProductResponseDto> stockpositivo(Integer n){
        List<Product> lista = productRepository.findByPrecioGreaterThan(n);
        List<ProductResponseDto> newlista = new ArrayList<>();
        for (Product product: lista){
            ProductResponseDto p1 = modelMapper.map(product,ProductResponseDto.class);
            newlista.add(p1);
        }
        return newlista;
    }

    public ProductResponseDto masStock(Long id, Integer n) throws LocalNotFoundException{
        Optional<Product> product1 = productRepository.findById(id);
        if (product1.isEmpty()){
            throw new LocalNotFoundException();
        }
        product1.get().plusStock(n);
        return modelMapper.map(product1.get(),ProductResponseDto.class);
    }
}
