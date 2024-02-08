package com.sksgroup.technozonebff.controller;

import com.sksgroup.technozonebff.dao.ProductService;
import com.sksgroup.technozonebff.dto.ProductDTO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(ProductAPIController.class)
class ProductAPIControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @InjectMocks
    private ProductAPIController productAPIController;

    @Test
    @Disabled
    void getProducts_shouldReturnListOfProducts() throws Exception {
        // Mocking the behavior of the ProductService
        List<ProductDTO> mockProducts = Arrays.asList(
                new ProductDTO("Printer", 10),
                new ProductDTO("Laptop", 30)
        );
        when(productService.getProducts()).thenReturn(mockProducts);

        // Performing the HTTP GET request and verifying the result
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/product"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(mockProducts.size()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Printer"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].quantity").value(10))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Laptop"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].quantity").value(30));
    }
}
