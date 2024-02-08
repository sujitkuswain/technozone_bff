package com.sksgroup.technozonebff.controller;

import com.sksgroup.technozonebff.dao.ProductService;
import com.sksgroup.technozonebff.model.Product;
import com.sksgroup.technozonebff.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductAPIController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepo productRepo;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<String> saveProduct(@RequestBody Product product) {
        productRepo.save(product);
        return ResponseEntity.ok("Product saved successfully");
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable String productId) {
        if (productRepo.existsById(productId)) {
            productRepo.deleteById(productId);
            return ResponseEntity.ok("Product deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<String> updateProduct(
            @PathVariable String productId,
            @RequestBody Product updatedProduct) {
        if (productRepo.existsById(productId)) {
            Product existingProduct = productRepo.findById(productId).orElse(null);

            if (existingProduct != null) {
                existingProduct.setName(updatedProduct.getName());
                existingProduct.setQuantity(updatedProduct.getQuantity());
                productRepo.save(existingProduct);

                return ResponseEntity.ok("Product updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating product");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
    }
}

