package com.thoughtworks.retail_in_future.sku.exception;

/**
 * Created by xyduan on 7/19/17.
 */
public class NotFoundException extends Exception {

    public NotFoundException(String s, String sku) {
        super(s + sku);
    }
}
