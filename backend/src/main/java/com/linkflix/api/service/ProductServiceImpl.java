package com.linkflix.api.service;

import com.linkflix.api.request.ProductReq;
import com.linkflix.api.request.ProductUpdateReq;
import com.linkflix.db.entity.Product;
import com.linkflix.db.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Optional;
import java.util.UUID;

@Service("productService")
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product saveProduct(MultipartFile file, ProductReq productReq) throws Exception {
        log.info("ProductServiceImpl /saveProduct/ productReq: " + productReq);

        String savePath = createProductImage(file); // 상품 이미지 서버에 저장
        productRepository.save(new Product(productReq.getSearchKeyword(), productReq.getName(), savePath)); // 상품 정보 DB 저장
        Product product = productRepository.findBySearchKeyword(productReq.getSearchKeyword());
        return product;
    }

    @Override
    public Optional<Product> getProduct(Long productId) {
        Optional<Product> product = productRepository.findById(productId);

        log.info("ProductServiceImpl/ getProduct/ product: " + product);
        return product;
    }

    @Override
    @Transactional
    public Product updateProduct(MultipartFile file, ProductUpdateReq productReq) throws Exception {
        log.info("ProductServiceImpl/ updateProduct");

        Product product = productRepository.findById(productReq.getId()).get();
        deleteProductImage(product.getImagePath()); // 기존 상품 이미지 삭제
        String savePath = createProductImage(file); // 새로운 이미지 등록

        // DB 수정
        product.setSearchKeyword(productReq.getSearchKeyword());
        product.setName(productReq.getName());
        product.setImagePath(savePath);
        return product;
    }

    @Override
    public void deleteProduct(Long productId) {
        log.info("ProductServiceImpl/ deleteProduct");

        Optional<Product> product = productRepository.findById(productId);
        deleteProductImage(product.get().getImagePath()); // 기존 상품 이미지 삭제
        productRepository.deleteById(productId); // DB 해당 열 삭제
    }

    public String createProductImage(MultipartFile file) throws Exception { // 상품 이미지 서버에 업로드하는 메서드
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
        return savePath;
    }

    public void deleteProductImage(String imagePath) { // 기존 상품 이미지 삭제 메서드
         log.info("ProductServiceImpl /deleteProductImage/ imagePath: " + imagePath);

         File file = new File(imagePath);
         if(file.exists()) {
             file.delete();
         }
    }

}
