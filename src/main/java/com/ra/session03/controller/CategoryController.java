package com.ra.session03.controller;

import com.ra.session03.model.dto.ResponseDTO;
import com.ra.session03.model.dto.category.CategoryRequestDTO;
import com.ra.session03.model.dto.category.CategoryResponseDTO;
import com.ra.session03.model.dto.category.CategoryUpdateRequestDTO;
import com.ra.session03.service.category.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
// lay ve tat ca
    @GetMapping
    public ResponseEntity<ResponseDTO<List<CategoryResponseDTO>>>index(){
        List<CategoryResponseDTO> responseDTOS = categoryService.findAll();
        ResponseDTO<List<CategoryResponseDTO>> response = new ResponseDTO<>(200,"Get all products success",responseDTOS);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    // danh sach co phan trang
//    @GetMapping
//    public ResponseEntity<?> index(
//            @RequestParam(defaultValue = "0",name = "page") int page,
//            @RequestParam(defaultValue = "3",name = "limit") int limit,
//            @RequestParam(defaultValue = "ASC",name = "order") String sort,
//            @RequestParam(defaultValue = "id",name = "sortBy") String sortBy
//            ){
//        Pageable pageable;
//        if(sort.equalsIgnoreCase("ASC")){
//            pageable = PageRequest.of(page,limit, Sort.by(sortBy).ascending());
//        } else {
//            pageable = PageRequest.of(page,limit, Sort.by(sortBy).descending());
//        }
//
//        Page<CategoryResponseDTO> categoryResponseDTOPage = categoryService.paginate(pageable);
//        return new ResponseEntity<>(categoryResponseDTOPage,HttpStatus.OK);
//    }
    @PostMapping
    public ResponseEntity<ResponseDTO<CategoryResponseDTO>> create(@RequestBody CategoryRequestDTO categoryRequestDTO){
        System.out.println(categoryRequestDTO.getCategoryName());
        CategoryResponseDTO responseDTO = categoryService.create(categoryRequestDTO);
        ResponseDTO<CategoryResponseDTO> response = new ResponseDTO<>(201,"create category success",responseDTO);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<CategoryResponseDTO>> findById(@PathVariable Long id){
        CategoryResponseDTO responseDTO = categoryService.findById(id);
        ResponseDTO<CategoryResponseDTO> response =
                new ResponseDTO<>(200,"get detail category by id "+id+" success",responseDTO);
        return new ResponseEntity<>(response,HttpStatus.OK);
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
