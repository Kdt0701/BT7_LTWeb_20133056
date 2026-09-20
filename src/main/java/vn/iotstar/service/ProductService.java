package vn.iotstar.service;

import vn.iotstar.dto.ProductDTO;
import java.util.List;

public interface ProductService {
    List<ProductDTO> getAll();
    ProductDTO getById(Long id);
    ProductDTO create(ProductDTO dto);
    ProductDTO update(Long id, ProductDTO dto);
    void delete(Long id);
}