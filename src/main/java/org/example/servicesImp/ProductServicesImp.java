package org.example.servicesImp;

import org.example.excption.APIException;
import org.example.model.Product;
import org.example.payload.ProductDTO;
import org.example.services.ProductServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class ProductServicesImp implements ProductServices {
    private static final Logger logger = LoggerFactory.getLogger(ProductServicesImp.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int createProduct(ProductDTO request) {
        String sql = "INSERT INTO products (title, description, price, size, created_at, updated_at) " + "VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                request.getTitle(),
                request.getDescription(),
                request.getPrice(),
                request.getSize(),
                LocalDateTime.now(),
                LocalDateTime.now());
    }

    @Override
    public int updateProduct(Long id, ProductDTO request) {

        String sql = "UPDATE products SET title = ?, description = ?, price = ?, size = ?, updated_at = ? WHERE id = ?";
        int updatedSuccess = jdbcTemplate.update(sql,
                request.getTitle(),
                request.getDescription(),
                request.getPrice(),
                request.getSize(),
                LocalDateTime.now(),
                id
        );
        if(updatedSuccess == 0){
            throw new APIException("This is not exists!");
        }
        return updatedSuccess;
    }

    @Override
    public int deleteProduct(Long id) {
        return jdbcTemplate.update("DELETE FROM products WHERE id = ?", id);
    }

    @Override
    public Product getProductById(Long id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Product.class), id);
    }

    @Override
    public List<Product> getAllProducts() {
        return jdbcTemplate.query("SELECT * FROM products", new BeanPropertyRowMapper<>(Product.class));
    }
}
