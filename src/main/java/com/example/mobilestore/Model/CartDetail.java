package com.example.mobilestore.Model;

import javax.persistence.*;

@Entity
@Table(name = "cart_detail")
public class CartDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_detail_ID")
    private Long cartDetailID;

    @Column(nullable = false)
    private Long cartid;

    @Column(nullable = false)
    private Long productID;

    private Integer price;

    private Integer quantity;

    public CartDetail(Long cartDetailID, Long cartid, Long productID, Integer price, Integer quantity) {
        this.cartDetailID = cartDetailID;
        this.cartid = cartid;
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
    }

    public CartDetail() {
    }

    public Long getCartDetailID() {
        return cartDetailID;
    }

    public void setCartDetailID(Long cartDetailID) {
        this.cartDetailID = cartDetailID;
    }

    public Long getCartID() {
        return cartid;
    }

    public void setCartID(Long cartid) {
        this.cartid = cartid;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartDetail{" +
                "CartDetailID=" + cartDetailID +
                ", CartID=" + cartid +
                ", ProductID=" + productID +
                ", Price=" + price +
                ", Quantity=" + quantity +
                '}';
    }
}
