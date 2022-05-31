package com.example.mobilestore.Model;

import javax.persistence.*;

@Entity
@Table(name = "Cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cartid",nullable = false)
    private Long cartID;

    @Column(nullable = false)
    private Long userID;

    public Cart(Long cartID, Long userID) {
        this.cartID = cartID;
        this.userID = userID;
    }

    public Cart() {
    }

    public Long getCartID() {
        return cartID;
    }

    public void setCartID(Long cartID) {
        this.cartID = cartID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "CartID=" + cartID +
                ", UserID=" + userID +
                '}';
    }
}
