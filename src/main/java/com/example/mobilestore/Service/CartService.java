package com.example.mobilestore.Service;

import com.example.mobilestore.Model.Cart;

public interface CartService {
    void createCart(Cart cart);
    Long getCartByUserID(Long userID);
}
