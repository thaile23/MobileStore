package com.example.mobilestore.Controller;

import com.example.mobilestore.Model.CartDetail;
import com.example.mobilestore.Model.Product;
import com.example.mobilestore.Service.CartDetailService;
import com.example.mobilestore.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    private CartDetailService cartDetailService;
    @Autowired
    private ProductService productService;

    @GetMapping("/Product/addtocart/{id}")
    public String AddtoCart(Model model, @PathVariable("id") Long id, HttpSession session) {
        Long cartid = (Long) session.getAttribute("cartID");
        String link = null;
        if(cartid == null){
            link = "redirect:/Login";
        }else{
            cartDetailService.AddToCartDetail(id, cartid);
            link = "redirect:/Cart/ShowCart";
        }
        return ""+link+"";
    }

    @GetMapping("Cart/ShowCart")
    public String showAllCart(Model model, HttpSession session) {
        Long cartid = (Long) session.getAttribute("cartID");
        List<CartDetail> listCart = cartDetailService.getAllCartByCartID(cartid);
        model.addAttribute("listCart", listCart);
        int SumCart = 0;
        if (listCart.size() == 0) {
            model.addAttribute("ListNull", "You don't have any product in cart");
        }
        List<Product> listProduct = new ArrayList<>();
        for (int i = 0; i < listCart.size(); i++) {
            Product product = productService.findProductById(listCart.get(i).getProductID());
            listProduct.add(product);

           SumCart += listCart.get(i).getPrice();

        }
        model.addAttribute("listProduct", listProduct);
        model.addAttribute("SumCart",SumCart);

        //Xu ly an hien login logout
        String username = (String) session.getAttribute("username");
        model.addAttribute("usernames", username);
        return "Cart";
    }
    @GetMapping("/Cart/delete/{id}")
    public String DeleteProduct(@PathVariable("id") Long id){
        cartDetailService.deleteProductInCart(id);
        return "redirect:/Cart/ShowCart";
    }

    @GetMapping("/Cart/ClearAll")
    public String ClearAllCart(HttpSession session){
        Long cartid = (Long) session.getAttribute("cartID");
        cartDetailService.clearAllCart(cartid);
        return "redirect:/Cart/ShowCart";
    }

}
