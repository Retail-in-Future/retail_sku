package com.thoughtworks.retail_in_future.sku.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Product")
@Table(name = "product")
public class Product {

    @Id
    @JsonProperty("SKU")
    private long id;

    @JsonProperty("productName")
    private String name;

    @JsonProperty("productCode")
    private String code;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
