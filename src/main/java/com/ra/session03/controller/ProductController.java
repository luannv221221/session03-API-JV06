package com.ra.session03.controller;

import com.ra.session03.model.dto.product.ProductResponseDTO;
import com.ra.session03.service.category.CategoryService;
import com.ra.session03.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<?> index(){
        List<ProductResponseDTO> responseDTOS = productService.findAll();
        return new ResponseEntity<>(responseDTOS, HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam(name = "keyword") String keyword){
        List<ProductResponseDTO> responseDTOS = productService.searchByProductName(keyword);
        return new ResponseEntity<>(responseDTOS, HttpStatus.OK);
    }
}
