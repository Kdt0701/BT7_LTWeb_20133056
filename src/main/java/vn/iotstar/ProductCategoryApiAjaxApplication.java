package vn.iotstar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import vn.iotstar.config.StorageProperties;

/**
 * Spring Boot application entry point for the exercise skeleton.
 */
@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class ProductCategoryApiAjaxApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductCategoryApiAjaxApplication.class, args);
    }
}
