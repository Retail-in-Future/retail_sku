package com.thoughtworks.retail_in_future.sku.service;


import com.thoughtworks.retail_in_future.sku.bean.Product;
import com.thoughtworks.retail_in_future.sku.exception.DuplicateException;
import com.thoughtworks.retail_in_future.sku.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product create(Product product) throws DuplicateException {

        if(productRepository.findFirstByName(product.getName()) != null){
            throw new DuplicateException(product.getName() + " is Duplicated");
        }else{

            return productRepository.save(product);
        }
    }

    public Product update(Product product) throws DuplicateException {

        Product productExist = productRepository.findFirstByName(product.getName());
        boolean isExist = productExist != null && !Objects.equals(productExist.getId(), product.getId());

        if(isExist){
            throw new DuplicateException(product.getName() + " is Duplicated");
        }else{

            return productRepository.save(product);
        }
    }



    public void delete(Product product) {
        productRepository.delete(product);
    }
}
