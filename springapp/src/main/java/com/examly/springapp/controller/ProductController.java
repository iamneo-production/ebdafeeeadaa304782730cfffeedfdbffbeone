package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Product;
import com.examly.springapp.repository.ProductRepo;

import java.util.List;



@RestController
public class ProductController {
        @Autowired
        private ProductRepo productRepository;

  

     @PostMapping("/addProduct")
    public int createProduct(@RequestBody Product product) {
        return productRepository.save(product).getProductId();
    }

     @GetMapping("/GetProductByProductId/{productId}")
    public Optional<Product> getProductsById(@PathVariable int productId) {
        return productRepository.findById(productId);
    }

    @GetMapping("/GetProduct")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }



    @GetMapping("/GetProductBycategoryId/{categoryid}")
    public List<Product> getProductsByCategory(@PathVariable int categoryid) {
        // Use the productRepository or your custom logic to retrieve products by category
        return productRepository.findByCategory_Id(categoryid);
    }



    // Define other CRUD operations for products as needed
}
