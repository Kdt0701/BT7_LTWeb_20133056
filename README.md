# Product Category REST API and AJAX

Spring Boot 3 exercise: Category REST API, Swagger 3 documentation, and Product/Category AJAX CRUD.

## Requirements

- Java 21 target, Maven, SQL Server 2019+.
- Create database: `CREATE DATABASE webst2;`
- Set credentials outside Git:

```powershell
$env:DB_USERNAME = "sa"
$env:DB_PASSWORD = "your-password"
```

The application uses `http://localhost:8082`, database `webst2`, and filesystem uploads in `uploads/`.

## Item 3 - Category REST API

- [x] Category CRUD with multipart icon upload.
- [x] Safe UUID image filenames, type/extension/size validation and traversal protection.
- [x] Duplicate-name protection, validation, centralized JSON errors and HTTP status codes.
- [x] Category search and paging: `GET /api/category/search?q=&page=0&size=10`.
- [x] Deletion is rejected if Products belong to the Category.

Category endpoints:

- `GET /api/category?q=`
- `POST /api/category/getCategory?id=`
- `POST /api/category/addCategory` (`categoryName`, optional `icon` multipart)
- `PUT /api/category/updateCategory` (`categoryId`, `categoryName`, optional `icon` multipart)
- `DELETE /api/category/deleteCategory?categoryId=`

All APIs return `{ "status", "message", "body" }`.

## Build and test

```powershell
mvn clean test
mvn clean package
mvn spring-boot:run
```

The automated test profile uses H2 only. Runtime uses SQL Server and requires `DB_PASSWORD` to be set. No password, uploads, PDFs, IDE settings or build output are committed.

## Item 4 - Swagger 3

- [x] Springdoc OpenAPI is used; Swagger 2, Springfox and `@EnableSwagger2` are not used.
- Swagger UI: `http://localhost:8082/swagger-ui/index.html`
- OpenAPI JSON: `http://localhost:8082/v3/api-docs`

## Item 5 - Product and AJAX CRUD

- [x] Product CRUD, Category relation, validation, duplicate detection, search/paging and safe image upload.
- [x] Category AJAX page: `http://localhost:8082/ajax/categories`
- [x] Product AJAX page: `http://localhost:8082/ajax/products`
- [x] Thymeleaf shell plus separate jQuery scripts in `static/js`.

Product endpoints:

- `GET /api/product?q=` and `GET /api/product/search?q=&page=0&size=10`
- `GET /api/product/{id}`
- `POST /api/product/addProduct` (multipart fields: `productName`, `quantity`, `unitPrice`, `description`, `discount`, `status`, `categoryId`, optional `imageFile`)
- `PUT /api/product/updateProduct` (same fields plus `productId`)
- `DELETE /api/product/deleteProduct?productId=`
