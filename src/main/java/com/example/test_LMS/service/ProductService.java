package com.example.test_LMS.service;

import com.example.test_LMS.model.Product;
import com.example.test_LMS.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product) {
        return repo.save(product);
    }

    public List<Product> addBulkProducts(List<Product> products) {
        try {
            return repo.saveAll(products);
        } catch (Exception e) {
            throw new RuntimeException("Error uploading products in bulk: " + e.getMessage());
        }
    }
    public Product updateProduct(int id, Product product) {
        Product existingProduct = repo.findById(id).orElse(null);
        if (existingProduct != null) {
            // Update only fields that are necessary
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setBrand(product.getBrand());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setReleaseDate(product.getReleaseDate());
            existingProduct.setProductAvailable(product.isProductAvailable());
            existingProduct.setStockQuantity(product.getStockQuantity());
            existingProduct.setImageUrl(product.getImageUrl());
            return repo.save(existingProduct);
        }
        return null;
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return repo.searchProducts(keyword);
    }
}
