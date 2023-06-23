package com.product.repository;

import com.product.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements IProductRepository{
    static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone 12", 12000000, "Black, Silver", "USA"));
        products.put(2, new Product(2, "Iphone 14", 24800000, "Pink, Gold", "Russia"));
        products.put(3, new Product(3, "Samsung A21S", 5000000, "Blue, Green", "China"));
        products.put(4, new Product(4, "Iphone 12 Pro", 15500000, "Black, Navy", "India"));
    }
    @Override
    public List<Product> showList() {
        return new ArrayList<>(products.values());
    }

    @Override
    public boolean add(Product product) {
        products.put(product.getId(), product);
        return true;
    }

    @Override
    public boolean update(Product product) {
        if(products.containsKey(product.getId())){
            products.put(product.getId(), product);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(int id) {
        if(products.containsKey(id)) {
            products.remove(id);
            return true;
        }

        return false;
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void search(String name) {
    }
}
