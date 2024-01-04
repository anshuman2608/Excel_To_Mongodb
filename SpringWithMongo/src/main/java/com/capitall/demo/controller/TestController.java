package com.capitall.demo.controller;

import java.util.List;
import com.capitall.demo.service.*;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.capitall.demo.model.ProductDetails;
import com.capitall.demo.service.ProductService;


@RestController
@CrossOrigin("*")
public class TestController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping(value="/hello")
	public String HelloTest() {
		
		return "hello from mongodb and springBoot";
	}
	
	@PostMapping("/save/upload")
	public  ResponseEntity<?> saveProducts(@PathVariable MultipartFile file) {
		if(Helper.checkExcelFormat(file)) {
			productService.save(file);
			return ResponseEntity.ok(Map.of("message","file uploaded succes fully"));
		}
		
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please upload valid file format");
	}
	
	@GetMapping("/getdata")
	public List<ProductDetails> getAllProducts() {
		System.out.println("all products fetched");
		return productService.getAllProducts();
	}
	
	

}
