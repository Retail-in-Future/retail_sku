package com.thoughtworks.retail_in_future.api;

import com.thoughtworks.retail_in_future.entry.ProductInfo;
import com.thoughtworks.retail_in_future.repository.ProductInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductApi {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @RequestMapping(value = "/getProductInfo", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getProductInfo(@PathParam("sku") String sku) {
        ProductInfo product = productInfoRepository.findFirstBySku(sku);

        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("result", 1);
        objectMap.put("data", product);
        return new ResponseEntity(objectMap, HttpStatus.OK);
    }
}
