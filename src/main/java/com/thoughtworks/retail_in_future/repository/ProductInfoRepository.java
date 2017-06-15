package com.thoughtworks.retail_in_future.repository;

import com.thoughtworks.retail_in_future.entry.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo, Long> {

    ProductInfo findFirstBySku(String sku);
}
