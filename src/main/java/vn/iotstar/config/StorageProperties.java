package vn.iotstar.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "storage")
public class StorageProperties {
    private String location = "uploads";
    private long maxFileSize = 5_242_880;
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public long getMaxFileSize() { return maxFileSize; }
    public void setMaxFileSize(long maxFileSize) { this.maxFileSize = maxFileSize; }
}
