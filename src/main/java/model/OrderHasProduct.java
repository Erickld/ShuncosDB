package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="Order_has_Product")
public class OrderHasProduct {
	
	@EmbeddedId
    private OrderProductId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderId")
    @JoinColumn(name = "Order_order_id")
    private Order order;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "Product_product_id")
    private Product product;
    
    @Column(name = "quantity")
    private int quantity;
    

    // Constructor with parameters
	public OrderHasProduct(OrderProductId id, Order order, Product product, int quantity) {
		super();
		this.id = id;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}
	
    // Default constructor
 	public OrderHasProduct() {
 		super();
 	}

	
	//Getters and setters
	public OrderProductId getId() {
		return id;
	}

	public void setId(OrderProductId id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
    
    // Embeddable key class
	@Embeddable
	public static class OrderProductId implements Serializable {
		
		@Column(name = "Order_order_id")
		private Long orderId;
		
		@Column(name = "Product_product_id")
		private Long productId;
		
		// Default constructor
		public OrderProductId() {
			super();
		}

		
		// Constructor with parameters
		public OrderProductId(Long orderId, Long productId) {
			super();
			this.orderId = orderId;
			this.productId = productId;
		}

		
		//Getters and setters
		public Long getOrderId() {
			return orderId;
		}


		public void setOrderId(Long orderId) {
			this.orderId = orderId;
		}


		public Long getProductId() {
			return productId;
		}


		public void setProductId(Long productId) {
			this.productId = productId;
		}

		
		// toString()
		@Override
		public String toString() {
			return "OrderProductId [orderId=" + orderId + ", productId=" + productId + "]";
		}
		
	
	}
    
 
}
