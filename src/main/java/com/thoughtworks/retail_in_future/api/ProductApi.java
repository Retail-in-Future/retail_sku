package com.thoughtworks.retail_in_future.api;

import com.thoughtworks.retail_in_future.entry.ProductInfo;
import com.thoughtworks.retail_in_future.repository.ProductInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    @RequestMapping(value = "/products/{sku}/stock", method = RequestMethod.POST)
    public void appendStock(@PathVariable("sku") String sku) {
        ProductInfo product = productInfoRepository.findFirstBySku(sku);
        product.setStock(product.getStock() + 1);
        productInfoRepository.save(product);
    }

    @RequestMapping(value = "/sse/products/{sku}/stock")
    public SseEmitter getStock(@PathVariable("sku") String sku) {
        ProductInfo product = productInfoRepository.findFirstBySku(sku);

        SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(() -> {
            try {
                emitter.send(product.getStock());

                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
                emitter.completeWithError(e);
                return;
            }
            emitter.complete();
        });

        return emitter;
    }}
