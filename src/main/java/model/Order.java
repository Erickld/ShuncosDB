package model;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="Order")
public class Order {

    // Columnas de la Tabla Order

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private Long id;

    @Column(name="create_at", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date create_at;

    @Column(name="status", nullable = false)
    private Long status;

    @Column(name="subtotal_price", nullable = false)
    private Double subtotalPrice;

    @Column(name="has_coupon", columnDefinition = "TINYINT")
    private Boolean hasCoupon;

    @Column(name="coupon_text", length = 50)
    private String couponText;

    @Column(name="discount_applied")
    private Double discountApplied;

    @Column(name="coupon_discount")
    private Double couponDiscount;

    @Column(name="shipment_price", nullable = false)
    private Double shipmentPrice;

    @Column(name="total_price", nullable = false)
    private Double totalPrice;

    // Relaciones de la tabla Order

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="User_user_id", nullable = false)
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Address_address_id", referencedColumnName = "address_id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Payment_payment_id", referencedColumnName = "payment_id")
    private Payment payment;

    @ManyToMany
    @JoinTable(
            name = "Order_has_Product",
            joinColumns = @JoinColumn(name = "Order_order_id"),
            inverseJoinColumns = @JoinColumn(name="Product_product_id")
    )
    private Set<Product> products;


    // Constructores tabla Order

    public Order() {

    }

    public Order(Long id, Date create_at, Long status, Double subtotalPrice, Boolean hasCoupon, String couponText, Double discountApplied, Double couponDiscount, Double shipmentPrice, Double totalPrice) {
        this.id = id;
        this.create_at = create_at;
        this.status = status;
        this.subtotalPrice = subtotalPrice;
        this.hasCoupon = hasCoupon;
        this.couponText = couponText;
        this.discountApplied = discountApplied;
        this.couponDiscount = couponDiscount;
        this.shipmentPrice = shipmentPrice;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Double getSubtotalPrice() {
        return subtotalPrice;
    }

    public void setSubtotalPrice(Double subtotalPrice) {
        this.subtotalPrice = subtotalPrice;
    }

    public Boolean getHasCoupon() {
        return hasCoupon;
    }

    public void setHasCoupon(Boolean hasCoupon) {
        this.hasCoupon = hasCoupon;
    }

    public String getCouponText() {
        return couponText;
    }

    public void setCouponText(String couponText) {
        this.couponText = couponText;
    }

    public Double getDiscountApplied() {
        return discountApplied;
    }

    public void setDiscountApplied(Double discountApplied) {
        this.discountApplied = discountApplied;
    }

    public Double getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(Double couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public Double getShipmentPrice() {
        return shipmentPrice;
    }

    public void setShipmentPrice(Double shipmentPrice) {
        this.shipmentPrice = shipmentPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", create_at=" + create_at +
                ", status=" + status +
                ", subtotalPrice=" + subtotalPrice +
                ", hasCoupon=" + hasCoupon +
                ", couponText='" + couponText + '\'' +
                ", discountApplied=" + discountApplied +
                ", couponDiscount=" + couponDiscount +
                ", shipmentPrice=" + shipmentPrice +
                ", totalPrice=" + totalPrice +
                ", user=" + user +
                ", address=" + address +
                ", payment=" + payment +
                ", products=" + products +
                '}';
    }
}