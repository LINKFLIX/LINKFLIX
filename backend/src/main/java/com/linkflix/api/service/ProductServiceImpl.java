package com.linkflix.api.service;

import com.linkflix.api.request.ProductReq;
import com.linkflix.db.entity.Product;
import com.linkflix.db.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service("productService")
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public String saveProduct(MultipartFile file, ProductReq productReq) throws Exception {
        File imageDirPath = new File("product_images");
        String originName = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String ext = originName.substring(originName.lastIndexOf(".") + 1);
        String savePath = imageDirPath.getAbsolutePath() + File.separator + uuid + "." + ext;

        File productFile = new File(savePath);
        if(!productFile.exists()) {
           productFile.mkdir();
        }
        file.transferTo(productFile);
        log.info("product-image upload path: " + productFile.getAbsolutePath());
        productRepository.save(new Product(productReq.getSearchKeyword(), productReq.getName(), savePath));

        return uuid;
    }


}
