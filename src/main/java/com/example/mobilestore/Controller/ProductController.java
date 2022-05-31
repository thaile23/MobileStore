package com.example.mobilestore.Controller;

import com.example.mobilestore.Model.Product;
import com.example.mobilestore.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String ShowAllProduct(Model model, HttpSession session) {
        List<Product> listProduct = productService.getAllProduct();
        model.addAttribute("ListProducts", listProduct);

        //Xu ly an hien login logout
        String username = (String) session.getAttribute("username");
        model.addAttribute("usernames", username);

        //Phan quyen user va admin
        int userType;
        if (session.getAttribute("UserType") != null) {
            userType = (int) session.getAttribute("UserType");
            model.addAttribute("checkAdmin", userType);
        }

        return "ShowProduct";
    }

    @GetMapping("/Products/ShowCreate")
    public String showAdd(Model model) {
        model.addAttribute("formProduct", new Product());
        return "AddProduct";
    }

    @PostMapping("/Products/Create")
    public String CreateProduct(Product product, RedirectAttributes re, @RequestParam("images") MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        product.setImage(fileName);
        Product pro = productService.CreateProduct(product);
        String uploadDir = "./src/main/resources/static/image";
        Path uploadPath = Paths.get(uploadDir);
        re.addFlashAttribute("message", "Create product successfully!!!");
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
        return "redirect:/";
    }

    @GetMapping("/Products/Detail/{id}")
    public String ShowProductDetail(Model model, @PathVariable("id") Long id, HttpSession session) {
        Product product = productService.findProductById(id);
        model.addAttribute("product", product);

        //Xu ly an hien login logout
        String username = (String) session.getAttribute("username");
        model.addAttribute("usernames", username);
        return "ShowProductDetail";
    }
}
