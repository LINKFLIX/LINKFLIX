package com.linkflix.api.service;

import com.linkflix.api.request.ProductReq;
import com.linkflix.api.request.ProductUpdateReq;
import com.linkflix.api.response.ProductRes;
import com.linkflix.db.entity.Product;
import org.springframework.web.multipart.MultipartFile;
public interface ProductService {

    ProductRes selectProduct(Product product);
    ProductRes saveProduct(MultipartFile file, ProductReq productReq) throws Exception;
    ProductRes getProduct(Long productId);
    byte[] getImage(String imagePath);
    String getMimeType(String imagePath);
    ProductRes updateProduct(MultipartFile file, ProductUpdateReq productReq) throws Exception;
    void deleteProduct(Long productId);

    String createProductImage(MultipartFile file) throws Exception;
    void deleteProductImage(String imagePath);

}
