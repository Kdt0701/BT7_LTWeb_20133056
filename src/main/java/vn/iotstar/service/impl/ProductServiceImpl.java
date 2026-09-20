package vn.iotstar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.iotstar.dto.ProductDTO;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.Product;
import vn.iotstar.repository.CategoryRepository;
import vn.iotstar.repository.ProductRepository;
import vn.iotstar.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    private ProductDTO toDTO(Product entity) {
        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setImage(entity.getImage());
        if (entity.getCategory() != null) {
            dto.setCategoryId(entity.getCategory().getId());
        }
        return dto;
    }

    private Product toEntity(ProductDTO dto) {
        Product entity = new Product();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setImage(dto.getImage());
        if (dto.getCategoryId() != null) {
            Category category = categoryRepository.findById(dto.getCategoryId()).orElse(null);
            entity.setCategory(category);
        }
        return entity;
    }

    @Override
    public List<ProductDTO> getAll() {
        return productRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public ProductDTO getById(Long id) {
        return productRepository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public ProductDTO create(ProductDTO dto) {
        Product entity = toEntity(dto);
        return toDTO(productRepository.save(entity));
    }

    @Override
    public ProductDTO update(Long id, ProductDTO dto) {
        return productRepository.findById(id).map(entity -> {
            entity.setName(dto.getName());
            entity.setPrice(dto.getPrice());
            entity.setImage(dto.getImage());
            if (dto.getCategoryId() != null) {
                Category category = categoryRepository.findById(dto.getCategoryId()).orElse(null);
                entity.setCategory(category);
            }
            return toDTO(productRepository.save(entity));
        }).orElse(null);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}