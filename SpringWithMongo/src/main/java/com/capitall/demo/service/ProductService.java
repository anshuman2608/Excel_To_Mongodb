package com.capitall.demo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.capitall.demo.model.ProductDetails;
import com.capitall.demo.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
    private ProductRepo repo;
	
	 Set<ProductDetails> products=new HashSet<>();

    public void save(MultipartFile file) {

        try {
            products = Helper.convertExcelToListOfProduct(file.getInputStream());
            
            List<ProductDetails> list1=repo.findAll();
            
            Set<ProductDetails> set1=new HashSet<>();
            set1.addAll(list1);
            
            
            repo.saveAll(set1);
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<ProductDetails> getAllProducts() {
        return repo.findAll();
    }

  
}
