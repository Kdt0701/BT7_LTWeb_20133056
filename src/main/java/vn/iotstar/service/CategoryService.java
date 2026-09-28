package vn.iotstar.service;
import vn.iotstar.dto.CategoryResponse; import org.springframework.data.domain.*; import org.springframework.web.multipart.MultipartFile; import java.util.*;
public interface CategoryService { List<CategoryResponse> findAll(String query); Page<CategoryResponse> search(String query, Pageable pageable); CategoryResponse findById(Long id); CategoryResponse create(String name, MultipartFile icon); CategoryResponse update(Long id,String name,MultipartFile icon); void delete(Long id); }
