package com.sksgroup.technozonebff.dao;

import com.sksgroup.technozonebff.dto.ProductDTO;
import com.sksgroup.technozonebff.model.Product;
import com.sksgroup.technozonebff.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public List<ProductDTO> getProducts(){
        return List.of(
                new ProductDTO("Printer", 10),
                new ProductDTO("Laptop", 30),
                new ProductDTO("Mouse", 5),
                new ProductDTO("Camera", 7)
        );
    }

    public List<Product> getAllProducts(){
      return productRepo.findAll();
    };
}
