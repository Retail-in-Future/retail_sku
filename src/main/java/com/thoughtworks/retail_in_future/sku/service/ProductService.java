package com.thoughtworks.retail_in_future.sku.service;


import com.thoughtworks.retail_in_future.sku.bean.Product;
import com.thoughtworks.retail_in_future.sku.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }


    public void delete(Product product) {
        productRepository.delete(product);
    }
}
