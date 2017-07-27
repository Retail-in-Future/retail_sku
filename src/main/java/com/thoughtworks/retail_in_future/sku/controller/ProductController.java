package com.thoughtworks.retail_in_future.sku.controller;


import com.thoughtworks.retail_in_future.sku.bean.Product;
import com.thoughtworks.retail_in_future.sku.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products/")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "ProductList", response = ResponseEntity.class)
    @RequestMapping(method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Map<String, Object>> list(){

        List<Product> productList =
                productService.findAll();

        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("result", 1);
        objectMap.put("data", productList);
        return new ResponseEntity(objectMap, HttpStatus.OK);
    }

    @ApiOperation(value = "create Product", response = List.class)
    @RequestMapping(method= RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Map<String, Object>> create(
            @RequestBody Product product
    ){

        productService.create(product);

        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("result", 1);

        return new ResponseEntity(objectMap, HttpStatus.OK);
    }

    @ApiOperation(value = "create Product", response = List.class)
    @RequestMapping(method= RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<Map<String, Object>> update(
            @RequestBody Product product
    ){

        productService.create(product);

        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("result", 1);

        return new ResponseEntity(objectMap, HttpStatus.OK);
    }

    @ApiOperation(value = "create Product", response = List.class)
    @RequestMapping(method= RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Map<String, Object>> delete(
            @RequestBody Product product
    ){
        productService.delete(product);

        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("result", 1);

        return new ResponseEntity(objectMap, HttpStatus.OK);
    }


}
