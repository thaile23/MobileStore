package com.example.mobilestore.Service.ServiceImpl;

import com.example.mobilestore.Model.CartDetail;
import com.example.mobilestore.Model.Product;
import com.example.mobilestore.Repository.CartDetailRepository;
import com.example.mobilestore.Repository.ProductRepository;
import com.example.mobilestore.Service.CartDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CartDetailServiceImpl implements CartDetailService {
    @Autowired
    private CartDetailRepository cartDetailRepository;
    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<CartDetail> getAllCartByCartID(Long Cartid) {

        List<CartDetail> listAllCartDetail = (List<CartDetail>) cartDetailRepository.findAll();
        List<CartDetail> listCartDetailByCartID = new ArrayList<>();
        for (int i = 0; i < listAllCartDetail.size(); i++) {
            if (listAllCartDetail.get(i).getCartID().equals(Cartid)) {
                listCartDetailByCartID.add(listAllCartDetail.get(i));
            }
        }
        return listCartDetailByCartID;
    }

    @Override
    public void AddToCartDetail(Long productid, Long cartid) {
        Product product = productRepository.findById(productid).get();
        List<CartDetail> listCartDetailByCart = getAllCartByCartID(cartid);
        boolean check = false;
        if(listCartDetailByCart.size()==0 && product.getUnitInStock() !=0){
            CartDetail cartDetail = new CartDetail();
            cartDetail.setCartID(cartid);
            cartDetail.setProductID(productid);
            cartDetail.setQuantity(1);
            cartDetail.setPrice(product.getUnitPrice());
            cartDetailRepository.save(cartDetail);
        }else {
            // trong cart da co product nen cap nhat quantity
            for (int i = 0; i < listCartDetailByCart.size(); i++) {
                if (listCartDetailByCart.get(i).getProductID() == productid && product.getUnitInStock() != 0) {
                    int quatity = listCartDetailByCart.get(i).getQuantity() + 1;
                    listCartDetailByCart.get(i).setQuantity(quatity);
                    int price = listCartDetailByCart.get(i).getQuantity() * product.getUnitPrice();
                    listCartDetailByCart.get(i).setPrice(price);
                    cartDetailRepository.save(listCartDetailByCart.get(i));
                    check = true;
                    break;
                }
            }
            if (check == false && product.getUnitInStock() != 0) {
                CartDetail cartDetail = new CartDetail();
                cartDetail.setCartID(cartid);
                cartDetail.setProductID(productid);
                cartDetail.setQuantity(1);
                cartDetail.setPrice(product.getUnitPrice());
                cartDetailRepository.save(cartDetail);
            }
        }
    }


    @Override
    public void deleteProductInCart(Long cartDetailId) {
        cartDetailRepository.deleteById(cartDetailId);
    }

    @Override
    public void clearAllCart(Long cartID) {
        List<CartDetail> listAllCartDetail = (List<CartDetail>) cartDetailRepository.findAll();
        for (int i = 0; i < listAllCartDetail.size(); i++) {
            if (listAllCartDetail.get(i).getCartID().equals(cartID)) {
                cartDetailRepository.deleteById(listAllCartDetail.get(i).getCartDetailID());
            }
        }
    }
}
