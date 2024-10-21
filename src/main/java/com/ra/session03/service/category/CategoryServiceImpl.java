package com.ra.session03.service.category;

import com.ra.session03.model.dto.category.CategoryRequestDTO;
import com.ra.session03.model.dto.category.CategoryResponseDTO;
import com.ra.session03.model.entity.Category;
import com.ra.session03.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository  categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryResponseDTO> findAll() {
        // convert Entity và DTO
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponseDTO> responseDTOS = new ArrayList<>();
        for (Category category : categories) {
            CategoryResponseDTO categoryItem = CategoryResponseDTO.builder()
                    .id(category.getId())
                    .categoryName(category.getCategoryName())
                    .categoryStatus(category.getCategoryStatus())
                    .build();
            responseDTOS.add(categoryItem);
        }
        return responseDTOS;
    }

    @Override
    public CategoryResponseDTO create(CategoryRequestDTO categoryRequestDTO) {
        Category category = Category.builder()
                .categoryName(categoryRequestDTO.getCategoryName())
                .categoryStatus(categoryRequestDTO.getCategoryStatus())
                .build();
        Category categoryNew = categoryRepository.save(category);

        return CategoryResponseDTO.builder()
                .id(categoryNew.getId())
                .categoryName(categoryNew.getCategoryName())
                .categoryStatus(categoryNew.getCategoryStatus())
                .build();
    }

    @Override
    public CategoryResponseDTO findById(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);

        return CategoryResponseDTO.builder()
                .id(category.getId())
                .categoryName(category.getCategoryName())
                .categoryStatus(category.getCategoryStatus())
                .build();
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
