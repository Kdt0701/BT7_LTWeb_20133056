# Spring Boot Product Category API AJAX
# COMMING SOON...
Repository chuẩn bị cho bài tập Lập trình Web ngày 16/09/2026, phần 2 (tiếp theo).

## Mục tiêu bài tập

Chuẩn bị một ứng dụng Spring Boot 3 có cấu trúc rõ ràng để lần lượt xây dựng API REST cho Category và Product, tài liệu hóa API, rồi kết nối giao diện bằng AJAX. Hiện repository chỉ là bộ khung; chưa có chức năng nghiệp vụ.

## Công nghệ dự kiến sử dụng

- Java 21 và Spring Boot 3
- Spring Web, Spring Data JPA, Validation
- Thymeleaf cho giao diện render phía máy chủ khi cần
- Lombok
- Microsoft SQL Server JDBC Driver
- jQuery/AJAX ở giai đoạn giao diện
- Springdoc OpenAPI (Swagger 3) ở mục 4
- Maven và Spring Boot Test

## Kế hoạch thực hiện

### Mục 3 - CRUD REST API

- [ ] Thiết kế Entity và quan hệ Category - Product.
- [ ] Cấu hình kết nối SQL Server bằng tệp môi trường cục bộ, không đưa thông tin nhạy cảm vào Git.
- [ ] Tạo Repository, Service, DTO/response và Controller.
- [ ] Hoàn thiện CRUD, kiểm tra validation, trạng thái HTTP và xử lý lỗi.
- [ ] Kiểm thử API bằng công cụ phù hợp.

### Mục 4 - API documentation

- [ ] Chỉ bổ sung Springdoc OpenAPI cho Spring Boot 3.
- [ ] Cấu hình metadata và kiểm tra Swagger UI.
- [ ] Không triển khai Swagger 2 hoặc Springfox.

> Lưu ý: mục 4 chỉ triển khai Swagger 3 bằng Springdoc OpenAPI, không triển khai Swagger 2/Springfox.

### Mục 5 - AJAX giao diện

- [ ] Tạo trang Thymeleaf và các tệp CSS/JS cần thiết.
- [ ] Hiển thị danh sách Category và Product từ REST API.
- [ ] Thêm, sửa, xóa bằng AJAX; dùng `FormData` nếu có upload.
- [ ] Hiển thị thông báo lỗi/thành công và kiểm thử luồng người dùng.

## Danh sách chức năng dự kiến

### Category

- Xem danh sách và chi tiết Category.
- Thêm, cập nhật, xóa Category.
- Kiểm tra tên Category trùng lặp.
- Tìm kiếm và phân trang khi triển khai yêu cầu chi tiết.
- Upload/quản lý icon khi đến phần upload.

### Product

- Xem danh sách và chi tiết Product.
- Thêm, cập nhật, xóa Product.
- Gán Product vào Category.
- Kiểm tra tên Product trùng lặp.
- Tìm kiếm và phân trang khi triển khai yêu cầu chi tiết.
- Upload/quản lý hình ảnh khi đến phần upload.

## Checklist tiến độ

- [ ] Hoàn thành mục 3: CRUD REST API.
- [ ] Hoàn thành mục 4: Springdoc OpenAPI / Swagger 3.
- [ ] Hoàn thành mục 5: giao diện AJAX.
- [ ] Kiểm thử toàn bộ luồng Category và Product.
- [ ] Hoàn thiện hướng dẫn chạy.
- [ ] Commit và push khi được yêu cầu.

## Cấu trúc thư mục dự kiến

```text
spring-boot-product-category-api-ajax/
├── src/
│   ├── main/
│   │   ├── java/vn/iotstar/
│   │   │   ├── config/
│   │   │   ├── controller/
│   │   │   ├── dto/
│   │   │   ├── entity/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   └── service/impl/
│   │   └── resources/
│   │       ├── static/
│   │       │   ├── css/
│   │       │   └── js/
│   │       └── templates/
│   └── test/
│       └── java/vn/iotstar/
├── .gitignore
├── pom.xml
└── README.md
```

## Hướng dẫn chạy

Sẽ bổ sung sau khi bắt đầu cấu hình cơ sở dữ liệu và triển khai chức năng.

## Phạm vi hiện tại

Chưa tạo Entity, Repository, Service, Controller, AJAX, cấu hình Swagger, cấu hình SQL Server hoặc chức năng upload. Không đưa PDF, tài khoản hay mật khẩu SQL Server vào repository.
