package com.thoughtworks.retail_in_future.sku.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/skus/")
public class SkuController {

    @ApiOperation(value = "View the stocks", response = ResponseEntity.class)
    @RequestMapping(method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Map<String, Object>> list(){

        Map<String, Object> objectMap = new HashMap<>();

        Map<String, Long> sku = new HashMap<>();
        sku.put("SKU", Math.abs(new Random().nextLong()));

        objectMap.put("result", 1);
        objectMap.put("data", sku);

        return new ResponseEntity(objectMap, HttpStatus.OK);
    }
}
