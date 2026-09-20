```markdown
# Spring Boot Product Category API AJAX

Repository hoàn chỉnh cho bài tập Lập trình Web - Hệ thống quản lý Danh mục (Category) và Sản phẩm (Product) xây dựng bằng Spring Boot 3, cung cấp RESTful API, tài liệu hóa bằng Swagger 3 (Springdoc OpenAPI) và kết nối giao diện phía máy khách bằng AJAX/jQuery.

## Mục tiêu bài tập

Xây dựng ứng dụng Spring Boot 3 chuẩn kiến trúc Layered Architecture (Controller - Service - Repository - Entity/DTO) để giải quyết các yêu cầu:
1. Triển khai CRUD RESTful API cho cả **Category** và **Product**.
2. Tự động hóa tài liệu API bằng **Springdoc OpenAPI (Swagger 3)**.
3. Xây dựng giao diện đơn trang (SPA) sử dụng **Thymeleaf + jQuery AJAX** để thao tác dữ liệu không cần load lại trang.

## Công nghệ sử dụng

- **Java**: 21
- **Framework**: Spring Boot 3.5.x (Spring Web, Spring Data JPA, Spring Validation)
- **Database**: Microsoft SQL Server
- **View Template**: Thymeleaf
- **Client Scripting**: jQuery, AJAX, Bootstrap 5
- **API Documentation**: Springdoc OpenAPI Starter WebMVC UI v2.3.0 (Swagger 3)
- **Library & Tools**: Lombok, Maven, Git/GitHub

---

## Tiến độ thực hiện

- [x] **Mục 3 - CRUD REST API**:
  - [x] Thiết kế Entity và quan hệ `@OneToMany` / `@ManyToOne` giữa Category và Product.
  - [x] Cấu hình kết nối SQL Server trong `application.properties`.
  - [x] Tạo DTO, Repository, Service/ServiceImpl và REST Controllers.
  - [x] Kiểm tra Validation, xử lý HTTP Status Code (200, 201, 204, 404, 400).
- [x] **Mục 4 - API Documentation**:
  - [x] Tích hợp Springdoc OpenAPI cho Spring Boot 3.
  - [x] Cấu hình OpenAPI Metadata (Title, Version, Description).
  - [x] Gắn nhãn `@Tag`, `@Operation` mô tả endpoints trong REST Controllers.
- [x] **Mục 5 - AJAX Giao diện**:
  - [x] Tạo trang quản lý Category (`/`) và Product (`/products`).
  - [x] Thực hiện toàn bộ thao tác Xem, Thêm, Sửa, Xóa bằng jQuery AJAX.
  - [x] Load danh sách Category động vào `select-box` khi tạo/chỉnh sửa Product.
- [x] **Kiểm thử & Đóng gói**:
  - [x] Kiểm thử toàn bộ luồng CRUD cho Category và Product.
  - [x] Hoàn thiện tệp `.gitignore` và hướng dẫn chạy.
  - [x] Commit và push mã nguồn lên GitHub repository.

---

## Cấu trúc thư mục dự án

```text
spring-boot-product-category-api-ajax/
├── src/
│   ├── main/
│   │   ├── java/vn/iotstar/
│   │   │   ├── Bt7LtWebApplication.java
│   │   │   ├── config/
│   │   │   │   └── OpenAPIConfig.java
│   │   │   ├── controller/
│   │   │   │   ├── CategoryApiController.java
│   │   │   │   ├── ProductApiController.java
│   │   │   │   └── WebController.java
│   │   │   ├── dto/
│   │   │   │   ├── CategoryDTO.java
│   │   │   │   └── ProductDTO.java
│   │   │   ├── entity/
│   │   │   │   ├── Category.java
│   │   │   │   └── Product.java
│   │   │   ├── repository/
│   │   │   │   ├── CategoryRepository.java
│   │   │   │   └── ProductRepository.java
│   │   │   └── service/
│   │   │       ├── CategoryService.java
│   │   │       ├── ProductService.java
│   │   │       └── impl/
│   │   │           ├── CategoryServiceImpl.java
│   │   │           └── ProductServiceImpl.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       └── templates/
│   │           ├── categories.html
│   │           └── products.html
│   └── test/
├── .gitignore
├── pom.xml
└── README.md

```

---

## Hướng dẫn chạy dự án

### 1. Yêu cầu môi trường

* Java Development Kit (JDK) 21 trở lên.
* Microsoft SQL Server đã cài đặt và đang bật dịch vụ.
* Maven 3.8+ (hoặc wrapper trong IDE).

### 2. Cấu hình Cơ sở dữ liệu

1. Mở **SQL Server Management Studio (SSMS)** và tạo cơ sở dữ liệu:
```sql
CREATE DATABASE LTWeb_BT7;
GO

```


2. Mở tệp `src/main/resources/application.properties` và điều chỉnh lại tài khoản SQL Server phù hợp với máy cục bộ:
```properties
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=LTWeb_BT7;encrypt=false;trustServerCertificate=true
spring.datasource.username=sa
spring.datasource.password=123456

```



### 3. Khởi chạy ứng dụng

* **Sử dụng Terminal / Command Line:**
```bash
mvn clean spring-boot:run

```


* **Sử dụng IDE (STS / Eclipse / IntelliJ):**
* Mở dự án, nhấp chuột phải vào file `Bt7LtWebApplication.java` chọn **Run As** $\rightarrow$ **Spring Boot App**.



### 4. Truy cập các đường dẫn

Sau khi ứng dụng khởi chạy thành công ở cổng `8080`:

* **Giao diện Quản lý Category (AJAX):** [http://localhost:8080/](http://localhost:8080/?utm_source=gemini)
* **Giao diện Quản lý Product (AJAX):** [http://localhost:8080/products](http://localhost:8080/products?utm_source=gemini)
* **Tài liệu Swagger UI (Mục 4):** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html?utm_source=gemini)
* **OpenAPI Docs (JSON):** [http://localhost:8080/api-docs](http://localhost:8080/api-docs?utm_source=gemini)

---

## Danh sách REST API Endpoints

### Category API (`/api/v1/categories`)

* `GET /api/v1/categories` - Lấy danh sách danh mục
* `GET /api/v1/categories/{id}` - Lấy chi tiết danh mục theo ID
* `POST /api/v1/categories` - Thêm mới danh mục
* `PUT /api/v1/categories/{id}` - Cập nhật danh mục theo ID
* `DELETE /api/v1/categories/{id}` - Xóa danh mục theo ID

### Product API (`/api/v1/products`)

* `GET /api/v1/products` - Lấy danh sách sản phẩm
* `GET /api/v1/products/{id}` - Lấy chi tiết sản phẩm theo ID
* `POST /api/v1/products` - Thêm mới sản phẩm (kèm `categoryId`)
* `PUT /api/v1/products/{id}` - Cập nhật sản phẩm theo ID
* `DELETE /api/v1/products/{id}` - Xóa sản phẩm theo ID

```

```