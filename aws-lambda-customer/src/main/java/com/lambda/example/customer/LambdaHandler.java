package com.lambda.example.customer;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.lambda.example.customer.model.Customer;
import com.lambda.example.customer.model.Request;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaHandler implements RequestHandler<Request, Object> {

    private List<Customer> customers = new ArrayList<>();

    @Override
    public Object handleRequest(Request request, Context context) {

        if(customers.stream().filter(c -> c.getId() == 1).collect(Collectors.toList()).size()== 0)
            customers.add(new Customer(1l,"Pratik","Sathaye","pratik@example.com","C/ la camara","Aviles"));
        if(customers.stream().filter(c -> c.getId() == 2).collect(Collectors.toList()).size()== 0)
            customers.add(new Customer(2l,"Martin","Fowler","martin@example.com","C/ la camara","Aviles"));
        if(customers.stream().filter(c -> c.getId() == 3).collect(Collectors.toList()).size()== 0)
            customers.add(new Customer(3l,"Bob","Martin","bob@example.com","C/ la camara","Aviles"));
        //IFileSystem importedFileSystem =

        switch (request.getHttpMethod()){
            case "GET":
                if(request.getId() == 0){
                    return customers;
                }else {
                    return customers.stream().filter(c -> c.getId() == request.getId()).collect(Collectors.toList());
                }
            case "POST":
                Customer c = request.getCustomer();
                if(c != null)
                    customers.add(c);
                return c;
            case "DELETE":
                Customer cus = customers.stream().filter(cu -> cu.getId() == request.getId()).collect(Collectors.toList()).get(0);
                customers.remove(cus);
                return customers;
        }
        return customers;
    }

}
