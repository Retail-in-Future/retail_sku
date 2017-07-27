package com.thoughtworks.retail_in_future.sku.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.retail_in_future.sku.bean.Product;
import com.thoughtworks.retail_in_future.sku.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.doReturn;


@RunWith(PowerMockRunner.class)
public class ProductControllerTest {

    @InjectMocks
    ProductController productController;

    @Mock
    ProductService productService;

    @Test
    public void shouldReturnProductList(){

        List<Product> productList = Arrays.asList(createProduct(1, "p1", "code1"), createProduct(2, "p2", "code1"), createProduct(1, "p1", "code1"), createProduct(3, "p3", "code1"));

        doReturn(productList).when(productService).findAll();

        ResponseEntity<Map<String, Object>> result = productController.list();

        List data = (List)result.getBody().get("data");
        Map data0 = new ObjectMapper().convertValue(data.get(0), Map.class);

        assertEquals(200, result.getStatusCodeValue());
        assertEquals("1", data0.get("sku").toString());
        assertEquals("p1", data0.get("productName").toString());
        assertEquals("code1", data0.get("productCode").toString());

    }


    @Test
    public void shouldDeleteProduct(){

    }

    private Product createProduct(long id, String name, String code) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setCode(code);
        return product;
    }


}