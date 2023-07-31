package com.cart.cart.dto;

import com.cart.cart.model.Product;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Integer> products = new HashMap<>();

    public CartDto() {
    }

    public CartDto(Map<ProductDto, Integer> products) {
        this.products = products;
    }

    public Map<ProductDto, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<ProductDto, Integer> products) {
        this.products = products;
    }

    public void addProduct(ProductDto productDto) {
        if (products.containsKey(productDto)) {
            //update value + 1
            Integer currentValue = products.get(productDto);
            products.put(productDto, currentValue + 1);
            products.replace(productDto, currentValue + 1);
        } else {
            products.put(productDto, 1); //Lan dau dc them vao
        }
    }

    public void increase(ProductDto productDto){
        products.put(productDto, products.get(productDto) + 1);
    }

    public void decrease(ProductDto productDto) {
        products.put(productDto, products.get(productDto) - 1);
    }

    private Map.Entry<ProductDto, Integer> selectItemInCart(Product product){
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            if(entry.getKey().getId() == product.getId()){
                return entry;
            }
        }
        return null;
    }

    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
}
