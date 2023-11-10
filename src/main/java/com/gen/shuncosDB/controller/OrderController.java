package com.gen.shuncosDB.controller;


import com.gen.shuncosDB.model.Order;
import com.gen.shuncosDB.model.OrderHasProduct;
import com.gen.shuncosDB.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("shuncos/orders")
public class OrderController {
    private final OrderService orderService;

    // Relaciones

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    // GET all Orders
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    // GET a single order by Id
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        if(order != null){
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Post an Order
    @PostMapping
    public Order createOrder(@RequestBody HashMap<String, String> json) {


        return null;
    }
}
