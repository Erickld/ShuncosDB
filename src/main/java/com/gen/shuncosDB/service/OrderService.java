package com.gen.shuncosDB.service;

import com.gen.shuncosDB.model.Order;
import com.gen.shuncosDB.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Get all products
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get one order by Id
    public Order getOrderById(Long id){
        return orderRepository.findById(id).orElse(null);
    }
}
