package vn.iotstar.entity;

import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity @Table(name = "Categories", uniqueConstraints = @UniqueConstraint(name = "uk_category_name", columnNames = "category_name"))
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long categoryId;
    @Column(name = "category_name", nullable = false, length = 150) private String categoryName;
    @Column(length = 255) private String icon;
    @OneToMany(mappedBy = "category") private Set<Product> products = new LinkedHashSet<>();
    public Long getCategoryId() { return categoryId; } public void setCategoryId(Long v) { categoryId=v; }
    public String getCategoryName() { return categoryName; } public void setCategoryName(String v) { categoryName=v; }
    public String getIcon() { return icon; } public void setIcon(String v) { icon=v; }
    public Set<Product> getProducts() { return products; } public void setProducts(Set<Product> v) { products=v; }
}
