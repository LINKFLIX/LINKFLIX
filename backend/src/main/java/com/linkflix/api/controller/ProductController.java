package com.linkflix.api.controller;

import com.linkflix.api.request.ProductReq;
import com.linkflix.api.request.ProductUpdateReq;
import com.linkflix.api.response.ProductRes;
import com.linkflix.api.service.ProductService;
import com.linkflix.common.BaseResponse;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Api(value = "상품(Product) API", tags = {"Product"})
@CrossOrigin
@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(value="/regist")
    public ResponseEntity<ProductRes> registProduct(@RequestParam("file") MultipartFile file, ProductReq productReq) throws Exception {
        log.info("POST /products/regist");

        ProductRes productRes = productService.saveProduct(file, productReq);
        return ResponseEntity.status(200).body(productRes);
    }

    @GetMapping(value="/{productId}")
    public ResponseEntity<ProductRes> getProduct(@PathVariable Long productId) {
        log.info("GET /products/" + productId);

        ProductRes productRes = productService.getProduct(productId);
        return ResponseEntity.status(200).body(productRes);
    }

    @GetMapping(value = "/image/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) {
        String imagePath = "product_images" + File.separator + imageName;
        log.info("GET /products/image/" + imagePath);

        byte[] image = productService.getImage(imagePath);
        HttpHeaders headers = new HttpHeaders();
        String mimeType = productService.getMimeType(imagePath);
        headers.add("Content-Type", mimeType);

        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }

    @PatchMapping(value="/update")
    public ResponseEntity<ProductRes> updateProduct(@RequestParam("file") MultipartFile file, ProductUpdateReq productReq) throws Exception {
        log.info("Patch /products/update");

        ProductRes productRes = productService.updateProduct(file, productReq);
        return ResponseEntity.status(200).body(productRes);
    }

    @DeleteMapping(value="/delete/{productId}")
    public ResponseEntity<? extends BaseResponse> deleteProduct(@PathVariable Long productId) {
        log.info("Delete /products/delete/" + productId);

        productService.deleteProduct(productId);
        return ResponseEntity.status(200).body(BaseResponse.of(200, "Success"));
    }

}

