package vn.iotstar.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity @Table(name = "Products", uniqueConstraints = @UniqueConstraint(name = "uk_product_name", columnNames = "product_name"))
public class Product {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="id") private Long productId;
 @Column(nullable=false, length=200) private String productName;
 @Column(name="name", nullable=false, length=200) private String legacyName;
 @Column(nullable=false) private Integer quantity; @Column(nullable=false, precision=19, scale=2) private BigDecimal unitPrice;
 @Column(name="price", nullable=false, precision=19, scale=2) private BigDecimal legacyPrice;
 @Column(length=255) private String images; @Column(nullable=false, length=1000) private String description;
 @Column(nullable=false, precision=5, scale=2) private BigDecimal discount; @Column(nullable=false) private LocalDateTime createDate;
 @Column(nullable=false) private Short status; @ManyToOne(fetch=FetchType.LAZY, optional=false) @JoinColumn(name="category_id", nullable=false) private Category category;
 public Long getProductId(){return productId;} public void setProductId(Long v){productId=v;} public String getProductName(){return productName;} public void setProductName(String v){productName=v;}
 public String getLegacyName(){return legacyName;} public void setLegacyName(String v){legacyName=v;}
 public Integer getQuantity(){return quantity;} public void setQuantity(Integer v){quantity=v;} public BigDecimal getUnitPrice(){return unitPrice;} public void setUnitPrice(BigDecimal v){unitPrice=v;}
 public BigDecimal getLegacyPrice(){return legacyPrice;} public void setLegacyPrice(BigDecimal v){legacyPrice=v;}
 public String getImages(){return images;} public void setImages(String v){images=v;} public String getDescription(){return description;} public void setDescription(String v){description=v;}
 public BigDecimal getDiscount(){return discount;} public void setDiscount(BigDecimal v){discount=v;} public LocalDateTime getCreateDate(){return createDate;} public void setCreateDate(LocalDateTime v){createDate=v;}
 public Short getStatus(){return status;} public void setStatus(Short v){status=v;} public Category getCategory(){return category;} public void setCategory(Category v){category=v;}
}
