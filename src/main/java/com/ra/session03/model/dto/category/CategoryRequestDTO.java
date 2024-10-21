package com.ra.session03.model.dto.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryRequestDTO {
    private Long id;
    private String categoryName;
    private Boolean categoryStatus;
}
