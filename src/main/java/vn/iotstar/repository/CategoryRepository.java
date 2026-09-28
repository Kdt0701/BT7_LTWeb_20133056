package vn.iotstar.repository;
import vn.iotstar.entity.Category; import org.springframework.data.domain.*; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface CategoryRepository extends JpaRepository<Category,Long> { Optional<Category> findByCategoryNameIgnoreCase(String name); boolean existsByCategoryNameIgnoreCase(String name); List<Category> findByCategoryNameContainingIgnoreCase(String name); Page<Category> findByCategoryNameContainingIgnoreCase(String name, Pageable pageable); }
