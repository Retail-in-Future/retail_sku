package com.thoughtworks.retail_in_future.sku.repository;

import com.thoughtworks.retail_in_future.sku.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
