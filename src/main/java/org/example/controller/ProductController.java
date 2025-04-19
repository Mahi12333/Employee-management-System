package org.example.controller;


import org.example.model.Product;
import org.example.payload.ProductDTO;
import org.example.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/api/product")
public class ProductController {
    @Autowired
    ProductServices productServices;

    @GetMapping("/")
    public String hello() {
        return "Hello, JDBC!";
    }

    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody ProductDTO request) {
        productServices.createProduct(request);
        return ResponseEntity.ok("Product created successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody ProductDTO request) {
        productServices.updateProduct(id, request);
        return ResponseEntity.ok("Product updated successfully!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productServices.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productServices.getProductById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productServices.getAllProducts());
    }


}
