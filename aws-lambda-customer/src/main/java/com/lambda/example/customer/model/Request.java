package com.lambda.example.customer.model;

import com.lambda.example.customer.model.Customer;

public class Request {

    private String httpMethod;

    private Long id;

    private Customer customer;

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }
}
