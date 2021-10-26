package com.linkflix.api.service;

import com.linkflix.api.request.ProductReq;
import com.linkflix.db.entity.Product;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {

    String saveProduct(MultipartFile file, ProductReq productReq) throws Exception;

}
