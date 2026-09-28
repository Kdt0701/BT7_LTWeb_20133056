package vn.iotstar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.nio.file.Path;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final StorageProperties properties;
    public WebConfig(StorageProperties properties) { this.properties = properties; }
    @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String location = Path.of(properties.getLocation()).toAbsolutePath().normalize().toUri().toString();
        registry.addResourceHandler("/uploads/**").addResourceLocations(location);
    }
}
