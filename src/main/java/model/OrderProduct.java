package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Order_has_Product")

public class OrderProduct {
	
	@Id
	@ManyToOne
	@JoinColumn(name="Order_order_id", referencedColumnName="order_id")
	private Order order;
	
	@Id
	@ManyToOne
	@JoinColumn(name="Product_product_id", referencedColumnName="product_id")
	private Product product;
	
	private int quantity;

	public OrderProduct() {
		super();
	}

	public OrderProduct(Order order, Product product, int quantity) {
		super();
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderProduct [product=" + product + ", quantity=" + quantity + "]";
	}
	


}
