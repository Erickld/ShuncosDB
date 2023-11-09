package com.gen.shuncosDB.model;

import java.util.HashMap;
import java.util.List;

public class CrudOrder {
	private Long status;
	private boolean has_coupon;
	private Double subtotal_price;
	private Double  shipment_price;
	private Double total_price;
	private	String coupon_text;
	private Double discount_applied;
	private Double coupon_percentage;
	private	String country;
	private String state;
	private String city;
	private String colony;
	private String street;
	private String zip_code;
	private String phone;
	private String card_number;
	private String owner_name;
	private String expiration_date;
	private String pin;
    private Long user_id;
    private List<HashMap<String, Long>> lista_productos;


	public CrudOrder() {
	}



	public CrudOrder(Long status, boolean has_coupon, Double subtotal_price, Double shipment_price, Double total_price,
			String coupon_text, Double discount_applied, Double coupon_percentage, String country, String state,
			String city, String colony, String street, String zip_code, String phone, String card_number,
			String owner_name, String expiration_date, String pin, Long user_id,
			List<HashMap<String, Long>> lista_productos) {
		super();
		this.status = status;
		this.has_coupon = has_coupon;
		this.subtotal_price = subtotal_price;
		this.shipment_price = shipment_price;
		this.total_price = total_price;
		this.coupon_text = coupon_text;
		this.discount_applied = discount_applied;
		this.coupon_percentage = coupon_percentage;
		this.country = country;
		this.state = state;
		this.city = city;
		this.colony = colony;
		this.street = street;
		this.zip_code = zip_code;
		this.phone = phone;
		this.card_number = card_number;
		this.owner_name = owner_name;
		this.expiration_date = expiration_date;
		this.pin = pin;
		this.user_id = user_id;
		this.lista_productos = lista_productos;
	}


	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public boolean isHas_coupon() {
		return has_coupon;
	}

	public void setHas_coupon(boolean has_coupon) {
		this.has_coupon = has_coupon;
	}

	public Double getSubtotal_price() {
		return subtotal_price;
	}

	public void setSubtotal_price(Double subtotal_price) {
		this.subtotal_price = subtotal_price;
	}

	public Double getShipment_price() {
		return shipment_price;
	}

	public void setShipment_price(Double shipment_price) {
		this.shipment_price = shipment_price;
	}

	public Double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getColony() {
		return colony;
	}

	public void setColony(String colony) {
		this.colony = colony;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}

	public String getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(String expiration_date) {
		this.expiration_date = expiration_date;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}


	
	public List<HashMap<String, Long>> getLista_productos() {
		return lista_productos;
	}



	public void setLista_productos(List<HashMap<String, Long>> lista_productos) {
		this.lista_productos = lista_productos;
	}



	public String getCoupon_text() {
		return coupon_text;
	}



	public void setCoupon_text(String coupon_text) {
		this.coupon_text = coupon_text;
	}



	public Double getDiscount_applied() {
		return discount_applied;
	}



	public void setDiscount_applied(Double discount_applied) {
		this.discount_applied = discount_applied;
	}



	public Double getCoupon_percentage() {
		return coupon_percentage;
	}



	public void setCoupon_percentage(Double coupon_percentage) {
		this.coupon_percentage = coupon_percentage;
	}



	@Override
	public String toString() {
		return "CrudOrder [status=" + status + ", has_coupon=" + has_coupon + ", subtotal_price=" + subtotal_price
				+ ", shipment_price=" + shipment_price + ", total_price=" + total_price + ", coupon_text=" + coupon_text
				+ ", discount_applied=" + discount_applied + ", coupon_percentage=" + coupon_percentage + ", country="
				+ country + ", state=" + state + ", city=" + city + ", colony=" + colony + ", street=" + street
				+ ", zip_code=" + zip_code + ", phone=" + phone + ", card_number=" + card_number + ", owner_name="
				+ owner_name + ", expiration_date=" + expiration_date + ", pin=" + pin + ", user_id=" + user_id
				+ ", lista_productos=" + lista_productos + "]";
	}

	
}
