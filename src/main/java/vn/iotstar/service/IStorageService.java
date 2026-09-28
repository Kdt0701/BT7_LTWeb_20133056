package vn.iotstar.service;
import org.springframework.core.io.Resource; import org.springframework.web.multipart.MultipartFile;
public interface IStorageService { String store(MultipartFile file); Resource loadAsResource(String filename); void delete(String filename); }
