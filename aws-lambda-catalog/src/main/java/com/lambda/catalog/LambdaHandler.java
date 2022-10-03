package com.lambda.catalog;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.lambda.catalog.model.Item;
import com.lambda.catalog.model.Request;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class LambdaHandler implements RequestHandler<Request, Object> {

    private List<Item> items = new ArrayList<>();

    @Override
    public Object handleRequest(Request request, Context context) {

        Item item1 = new Item();
        item1.setId(1l);
        item1.setName("vino");
        item1.setPrice(5.20);
        Item item2 = new Item();
        item2.setId(2l);
        item2.setName("cortinas");
        item2.setPrice(15.00);
        Item item3 = new Item();
        item3.setId(3l);
        item3.setName("altavoces");
        item3.setPrice(140.35);

        if (items.stream().filter(i -> i.getId() == 1l).collect(Collectors.toList()).size() == 0)
            items.add(item1);
        if (items.stream().filter(i -> i.getId() == 2l).collect(Collectors.toList()).size() == 0)
            items.add(item2);
        if (items.stream().filter(i -> i.getId() == 3l).collect(Collectors.toList()).size() == 0)
            items.add(item3);

        switch (request.getHttpMethod()){
            case "GET":
                if(request.getId() == null && request.getName() == null){
                    return items;
                }else {
                    if(request.getName() != null){
                        return items.stream().filter(c -> c.getName().equals(request.getName()))
                                .collect(Collectors.toList());
                    }else{
                        return items.stream().filter(c -> c.getId().equals(request.getId()))
                                .collect(Collectors.toList());
                    }
                }
            case "POST":
                Item i = request.getItem();
                if(i != null)
                    items.add(i);
                return i;
            case "DELETE":
                Item item = items.stream().filter(it -> it.getId() == request.getId()).collect(Collectors.toList()).get(0);
                items.remove(item);
                return items;
        }
        return items;
    }

}
