package com.ra.session03.controller;

import com.ra.session03.model.dto.category.CategoryRequestDTO;
import com.ra.session03.model.dto.category.CategoryResponseDTO;
import com.ra.session03.model.dto.category.CategoryUpdateRequestDTO;
import com.ra.session03.service.category.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
// lay ve tat ca
//    @GetMapping
//    public ResponseEntity<List<CategoryResponseDTO>> index(){
//        List<CategoryResponseDTO> responseDTOS = categoryService.findAll();
//        return new ResponseEntity<>(responseDTOS, HttpStatus.OK);
//    }
    // danh sach co phan trang
    @GetMapping
    public ResponseEntity<?> index(
            @RequestParam(defaultValue = "0",name = "page") int page,
            @RequestParam(defaultValue = "3",name = "limit") int limit
            ){
        Pageable pageable = PageRequest.of(page,limit);
        Page<CategoryResponseDTO> categoryResponseDTOPage = categoryService.paginate(pageable);
        return new ResponseEntity<>(categoryResponseDTOPage,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CategoryResponseDTO> create(@RequestBody CategoryRequestDTO categoryRequestDTO){
        System.out.println(categoryRequestDTO.getCategoryName());
        CategoryResponseDTO responseDTO = categoryService.create(categoryRequestDTO);
        return new ResponseEntity<>(responseDTO,HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        CategoryResponseDTO responseDTO = categoryService.findById(id);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> update(@PathVariable Long id, @RequestBody CategoryUpdateRequestDTO categoryRequestDTO){
        categoryRequestDTO.setId(id);
        CategoryResponseDTO responseDTO = categoryService.create(categoryRequestDTO);
        return new ResponseEntity<>(responseDTO,HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
