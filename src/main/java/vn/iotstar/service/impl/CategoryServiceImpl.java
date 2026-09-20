package vn.iotstar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.iotstar.dto.CategoryDTO;
import vn.iotstar.entity.Category;
import vn.iotstar.repository.CategoryRepository;
import vn.iotstar.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    private CategoryDTO toDTO(Category entity) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setIcon(entity.getIcon());
        return dto;
    }

    private Category toEntity(CategoryDTO dto) {
        Category entity = new Category();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setIcon(dto.getIcon());
        return entity;
    }

    @Override
    public List<CategoryDTO> getAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getById(Long id) {
        return repository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public CategoryDTO create(CategoryDTO dto) {
        Category entity = toEntity(dto);
        return toDTO(repository.save(entity));
    }

    @Override
    public CategoryDTO update(Long id, CategoryDTO dto) {
        return repository.findById(id).map(entity -> {
            entity.setName(dto.getName());
            entity.setIcon(dto.getIcon());
            return toDTO(repository.save(entity));
        }).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}