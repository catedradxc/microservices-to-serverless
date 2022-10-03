package com.lambda.order.model;

public class Request {

    private String httpMethod;
    private Long id;
    private Order order;

    public String getHttpMethod() {
        return httpMethod;
    }

    public Long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
