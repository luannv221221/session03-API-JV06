package com.ra.session03.service.product;

import com.ra.session03.model.dto.category.CategoryResponseDTO;
import com.ra.session03.model.dto.product.ProductResponseDTO;
import com.ra.session03.model.entity.Product;
import com.ra.session03.repository.ProductRepository;
import com.ra.session03.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public List<ProductResponseDTO> findAll() {
        List<Product> products = productRepository.findAll();
        List<ProductResponseDTO> responseDTOS = new ArrayList<>();
        for (Product product : products) {
            // cach 1
//            CategoryResponseDTO categoryResponseDTO = CategoryResponseDTO
//            .builder().
//            id(product.getCategory().getId())
//                    .categoryName(product.getCategory().getCategoryName())
//                    .categoryStatus(product.getCategory().getCategoryStatus())
//                    .build();

            ProductResponseDTO responseDTO = new ProductResponseDTO();
            responseDTO.setId(product.getId());
            responseDTO.setProductName(product.getProductName());
            responseDTO.setImage(product.getImage());
            responseDTO.setPrice(product.getPrice());
            // cach 1
//            responseDTO.setCategory(categoryResponseDTO);
            responseDTO.setCategory(product.getCategory()); // cach 2
            responseDTOS.add(responseDTO);
        }
        return responseDTOS;
    }
}
