package com.sksgroup.technozonebff.repo;

import com.sksgroup.technozonebff.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepo extends MongoRepository<Product, String > {
}
