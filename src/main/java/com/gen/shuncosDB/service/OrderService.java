package com.gen.shuncosDB.service;

import com.gen.shuncosDB.model.Address;
import com.gen.shuncosDB.model.CrudOrder;
import com.gen.shuncosDB.model.Order;
import com.gen.shuncosDB.model.Payment;
import com.gen.shuncosDB.model.User;
//import com.gen.shuncosDB.repository.AddressRepository;
import com.gen.shuncosDB.repository.OrderRepository;
//import com.gen.shuncosDB.repository.PaymentRepository;
import com.gen.shuncosDB.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private UserRepository userRepository;
    
//    @Autowired
//    private AddressRepository addressRepository;
//
//    @Autowired
//    private PaymentRepository paymentRepository;

    // Get all products
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get one order by Id
    public Order getOrderById(Long id){
        return orderRepository.findById(id).orElse(null);
    }
    
	//Post
    @Transactional
	public Boolean createOrder(CrudOrder crudOrder) {	
    	Order order = crudOrder.getOrder();
        Address address = crudOrder.getAddress();
        Payment payment = crudOrder.getPayment();
        
        Calendar today = Calendar.getInstance();    	
    	order.setCreate_at(today.getTime());
        
        //agregando address
    	order.setAddress(address);
    	address.setOrder(order);
        //addressRepository.save(address);
        
        //agregando payment
    	order.setPayment(payment);
    	payment.setOrder(order);
        //paymentRepository.save(payment);
        
        //agregando usuario a la orden
        User usr = userRepository.findById(crudOrder.getUser_id()).orElse(null);
        order.setUser(usr);
        usr.getOrder().add(order);
        //userRepository.save(usr);

        //agregar producto
        //order.addProduct(json)
        
        return true;
        //orderRepository.save(order);
	}
    
}
