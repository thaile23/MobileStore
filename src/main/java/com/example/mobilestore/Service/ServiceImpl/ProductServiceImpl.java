package com.example.mobilestore.Service.ServiceImpl;

import com.example.mobilestore.Model.Product;
import com.example.mobilestore.Repository.ProductRepository;
import com.example.mobilestore.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product CreateProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public Product findProductById(Long id) {
        Optional<Product> product =productRepository.findById(id);
        return product.get();
    }
}
