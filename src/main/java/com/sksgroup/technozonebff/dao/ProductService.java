package com.sksgroup.technozonebff.dao;

import com.sksgroup.technozonebff.dto.ProductDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    public List<ProductDTO> getProducts(){
        return List.of(
                new ProductDTO("Printer", 10),
                new ProductDTO("Laptop", 30)
        );
    }
}
