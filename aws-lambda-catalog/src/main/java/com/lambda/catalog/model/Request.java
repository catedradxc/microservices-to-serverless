package com.lambda.catalog.model;


public class Request {

    private String httpMethod;

    private Long id;

    private String name;

    private Item item;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public Long getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }
}

