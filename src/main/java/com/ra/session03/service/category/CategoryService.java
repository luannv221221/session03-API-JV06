package com.ra.session03.service.category;

import com.ra.session03.model.dto.category.CategoryRequestDTO;
import com.ra.session03.model.dto.category.CategoryResponseDTO;
import com.ra.session03.model.dto.category.CategoryUpdateRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDTO> findAll();
    CategoryResponseDTO create(CategoryRequestDTO categoryRequestDTO);
    CategoryResponseDTO findById(Long id);
    CategoryResponseDTO create(CategoryUpdateRequestDTO categoryRequestDTO);
    void delete(Long id);
    // phân trang
    Page<CategoryResponseDTO> paginate(Pageable pageable);
}
