package vn.iotstar.service;

import vn.iotstar.dto.CategoryDTO;
import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAll();
    CategoryDTO getById(Long id);
    CategoryDTO create(CategoryDTO dto);
    CategoryDTO update(Long id, CategoryDTO dto);
    void delete(Long id);
}