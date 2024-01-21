package com.sksgroup.technozonebff.controller;

import com.sksgroup.technozonebff.dao.ProductService;
import com.sksgroup.technozonebff.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductAPIController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<ProductDTO> getProducts(){
        return productService.getProducts();
    }
}
