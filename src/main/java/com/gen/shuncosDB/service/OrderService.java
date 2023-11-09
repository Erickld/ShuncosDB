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

import java.util.ArrayList;
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

	//Get orders filter by user
	public List<Order> getOrdersByUser(Long user_id){
		List<Order> filterOrders = new ArrayList<>();
		for (Order order : orderRepository.findAll()) {
			if (order.getUser().getUser_id() == user_id) {
				filterOrders.add(order);
			}
		}
		return filterOrders;
	}
    
    
    // Get one order by Id
    public Order getOrderById(Long id){
        return orderRepository.findById(id).orElse(null);
    }
    
	//Post
    @Transactional
	public Order createOrder(CrudOrder crudOrder) {
    	Calendar today = Calendar.getInstance();    	
    	
    	Order order = new Order();
    	order.setCreate_at(today.getTime());

        order.setStatus(crudOrder.getStatus());
        order.setSubtotal_price(crudOrder.getSubtotal_price());
        order.setHas_coupon(crudOrder.isHas_coupon());
        if (crudOrder.isHas_coupon()) {
            order.setCoupon_text(crudOrder.getCoupon_text());
            order.setDiscount_applied(crudOrder.getDiscount_applied());
            order.setCoupon_percentage(crudOrder.getCoupon_percentage());
        }
        order.setShipment_price(crudOrder.getShipment_price());
        order.setTotal_price(crudOrder.getTotal_price());
        
        //agregando address
        Address address = new Address();
    	address.setCountry(crudOrder.getCountry());
    	address.setState(crudOrder.getState());
    	address.setCity(crudOrder.getCity());
    	address.setColony(crudOrder.getColony());
    	address.setStreet(crudOrder.getStreet());
    	address.setZip_code(crudOrder.getZip_code());
    	address.setPhone(crudOrder.getPhone());
    	
    	order.setAddress(address);
    	address.setOrder(order);
//        addressRepository.save(address);
        

    	//agregando payment
        Payment payment = new Payment();        
    	payment.setCard_number(crudOrder.getCard_number());
    	payment.setOwner_name(crudOrder.getOwner_name());
    	payment.setExpiration_date(crudOrder.getExpiration_date());
    	payment.setPin(crudOrder.getPin());
        
    	order.setPayment(payment);
    	payment.setOrder(order);
//        paymentRepository.save(payment);
        
        //agregando usuario a la orden
        User usr = userRepository.findById(crudOrder.getUser_id()).orElse(null);
        order.setUser(usr);
        usr.getOrder().add(order);
//        userRepository.save(usr);

        //agregar productos a la orden
        //order.addProduct(json)
        
        return orderRepository.save(order);
	}
    
}
