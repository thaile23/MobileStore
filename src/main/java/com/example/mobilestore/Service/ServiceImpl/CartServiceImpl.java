package com.example.mobilestore.Service.ServiceImpl;

import com.example.mobilestore.Model.Cart;
import com.example.mobilestore.Repository.CartRepository;
import com.example.mobilestore.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public void createCart(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public Long getCartByUserID(Long Userid) {
        List<Cart> listCart = (List<Cart>) cartRepository.findAll();
       boolean checkCart= false;
        Long cartID = null ;
        for(int i =0 ; i < listCart.size(); i++){
            if(listCart.get(i).getUserID()==Userid){
                checkCart = true;
                cartID = listCart.get(i).getCartID();
            }
        }
        if(checkCart == false) {
            Cart cart = new Cart();
            cart.setUserID(Userid);
            cartRepository.save(cart);
            cartID = cart.getCartID();
        }
        return cartID;
    }
}
