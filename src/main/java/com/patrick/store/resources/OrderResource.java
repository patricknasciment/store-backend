package com.patrick.store.resources;

import com.patrick.store.domain.Client;
import com.patrick.store.domain.Order;
import com.patrick.store.service.ClientService;
import com.patrick.store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Integer id){
        Order order = service.findById(id);
        return ResponseEntity.ok().body(order);
    }

}
