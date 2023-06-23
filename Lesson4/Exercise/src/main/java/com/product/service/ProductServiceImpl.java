package com.product.service;

import com.product.model.Product;
import com.product.repository.IProductRepository;
import com.product.repository.ProductRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{
    private IProductRepository iProductRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> showList() {
        return iProductRepository.showList();
    }

    @Override
    public boolean add(Product product) {
        return iProductRepository.add(product);
    }

    @Override
    public boolean update(Product product) {
        iProductRepository.update(product);
        return true;
    }

    @Override
    public boolean remove(int id) {
        iProductRepository.remove(id);
        return true;
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void search(String name) {

    }
}
