package com.example.pc1.product.infrastructure;

import com.example.pc1.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByPrecioGreaterThan(Integer n);
    Product findByDescripcion(String description);
}
