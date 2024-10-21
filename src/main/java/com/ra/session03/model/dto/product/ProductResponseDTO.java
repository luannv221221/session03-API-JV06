package com.ra.session03.model.dto.product;

import com.ra.session03.model.dto.category.CategoryResponseDTO;
import com.ra.session03.model.entity.Category;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductResponseDTO {
    private Long id;
    private String productName;
    private Double price;
    private String image;
    //    private CategoryResponseDTO category; // cach 1
    private Category category; // cach 2

}