package org.example.services;

import org.example.model.Product;
import org.example.payload.ProductDTO;

import java.util.List;

public interface ProductServices {
    int createProduct(ProductDTO request);
    int updateProduct(Long id, ProductDTO request);
    int deleteProduct(Long id);
    Product getProductById(Long id);
    List<Product> getAllProducts();

}
