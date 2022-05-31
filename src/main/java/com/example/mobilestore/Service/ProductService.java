package com.example.mobilestore.Service;

import com.example.mobilestore.Model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProduct();
    Product CreateProduct(Product product);

    Product findProductById(Long id);

}
