package com.product.service;

import com.product.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> showList();
    boolean add(Product product);
    boolean update(Product product);
    boolean remove(int id);
    Product findById(int id);
    void search(String name);
}
