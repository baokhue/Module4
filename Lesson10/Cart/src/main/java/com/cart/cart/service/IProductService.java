package com.cart.cart.service;

import com.cart.cart.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);

    Product findById(long id);

    void save(Product product);
}
