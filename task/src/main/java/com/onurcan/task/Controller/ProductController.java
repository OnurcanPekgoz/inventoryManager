package com.onurcan.task.Controller;

import com.onurcan.task.Entity.Product;
import com.onurcan.task.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public Product addProduct(@RequestParam String productName) {
        Product product = new Product();
        product.setName(productName);
        return productService.addProduct(product);
    }

    @DeleteMapping("/delete/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }

    @GetMapping("/list")
    public List<Product> listProducts() {
        return productService.listProducts();
    }
}

