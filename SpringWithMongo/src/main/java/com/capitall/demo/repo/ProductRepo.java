package com.capitall.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capitall.demo.model.ProductDetails;

public interface ProductRepo extends MongoRepository<ProductDetails,String>{

}
