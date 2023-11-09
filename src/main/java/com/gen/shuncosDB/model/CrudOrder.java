package com.gen.shuncosDB.model;

public class CrudOrder {
    private Order order;
    private Address address;
    private Payment payment;
    private Long user_id;

	public CrudOrder() {
	}
    
	public CrudOrder(Order order, Address address, Payment payment, Long user_id) {
		this.order = order;
		this.address = address;
		this.payment = payment;
		this.user_id = user_id;
	}

	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	
}
