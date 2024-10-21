package com.ra.session03.service.product;

import com.ra.session03.model.dto.product.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    List<ProductResponseDTO> findAll();
}
