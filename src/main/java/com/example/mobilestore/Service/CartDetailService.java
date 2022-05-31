package com.example.mobilestore.Service;

import com.example.mobilestore.Model.CartDetail;

import java.util.List;

public interface CartDetailService {
    List<CartDetail> getAllCartByCartID(Long Cartid);
    void AddToCartDetail(Long productid,Long cartid);
    void deleteProductInCart(Long id);
    void clearAllCart(Long cartID);
}
