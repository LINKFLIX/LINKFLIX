package com.linkflix.api.service;

import com.linkflix.api.request.ProductReq;
import com.linkflix.api.request.ProductUpdateReq;
import com.linkflix.db.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface ProductService {

    Product saveProduct(MultipartFile file, ProductReq productReq) throws Exception;
    Optional<Product> getProduct(Long productId);
    Product updateProduct(MultipartFile file, ProductUpdateReq productReq) throws Exception;
    void deleteProduct(Long productId);

    String createProductImage(MultipartFile file) throws Exception;
    void deleteProductImage(String imagePath);
}
