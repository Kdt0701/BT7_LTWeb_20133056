package vn.iotstar.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    OpenAPI productCategoryOpenApi() {
        return new OpenAPI().info(new Info().title("Product Category REST API").version("1.0.0")
                .description("Bài tập Lập trình Web: CRUD Category, Product và AJAX."))
                .addServersItem(new Server().url("http://localhost:8082").description("Local server"));
    }
}
