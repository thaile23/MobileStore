package com.example.mobilestore.Controller;


import com.example.mobilestore.Model.User;
import com.example.mobilestore.Service.CartService;
import com.example.mobilestore.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired private CartService cartService;

    @GetMapping("/users")
    public String ShowUser(Model model) {
        List<User> listUser = userService.getAllUser();
        model.addAttribute("listUsers", listUser);
        return "showUser";
    }

    @GetMapping("/Login")
    public String Log() {
        return "LoginForm";
    }

    @RequestMapping(path = "/check", method = RequestMethod.POST)
    public String Login(Model model, String username, String password, HttpSession session, RedirectAttributes re) {
        String a = null;
        if (userService.LoginUser(username.toLowerCase().trim(), password.toLowerCase().trim())) {
            a = "redirect:/";
            User user = userService.findUserByUsername(username);
            Long cartID = cartService.getCartByUserID(user.getUserID());
            session.setAttribute("cartID", cartID);
            session.setAttribute("username", user.getUserName());
            session.setAttribute("UserType", user.getUserType());
            session.setAttribute("userid", user.getUserID());
        } else {
            re.addFlashAttribute("message", "Username or password are not correct");
            a = "redirect:/Login";
        }
        return ""+ a +"";
    }
    @GetMapping("/Logout")
    public String Logout(HttpSession session){
        session.removeAttribute("cartID");
        session.removeAttribute("username");
        session.removeAttribute("UserType");
        session.removeAttribute("userid");
        return "redirect:/";
    }

}
