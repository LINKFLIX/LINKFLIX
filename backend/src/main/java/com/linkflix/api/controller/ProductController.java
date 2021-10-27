package com.linkflix.api.controller;

import com.linkflix.api.request.ProductReq;
import com.linkflix.api.request.ProductUpdateReq;
import com.linkflix.api.service.ProductService;
import com.linkflix.common.BaseResponse;
import com.linkflix.db.entity.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Api(value = "상품(Product) API", tags = {"Product"})
@CrossOrigin
@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(value="/regist")
    public ResponseEntity<Product> registProduct(@RequestParam("file") MultipartFile file, ProductReq productReq) throws Exception {
        log.info("POST /products/regist");

        Product product = productService.saveProduct(file, productReq);
        return ResponseEntity.status(200).body(product);
    }

    @GetMapping(value="/{productId}")
    public ResponseEntity<Optional<Product>> getProduct(@PathVariable Long productId) {
        log.info("GET /products/" + productId);

        Optional<Product> product = productService.getProduct(productId);
        return ResponseEntity.status(200).body(product);
    }

    @PatchMapping(value="/update")
    public ResponseEntity<Product> updateProduct(@RequestParam("file") MultipartFile file, ProductUpdateReq productReq) throws Exception {
        log.info("Patch /products/update");

        Product product = productService.updateProduct(file, productReq);
        return ResponseEntity.status(200).body(product);
    }

    @DeleteMapping(value="/delete/{productId}")
    public ResponseEntity<? extends BaseResponse> deleteProduct(@PathVariable Long productId) {
        log.info("Delete /products/delete/" + productId);

        productService.deleteProduct(productId);
        return ResponseEntity.status(200).body(BaseResponse.of(200, "Success"));
    }

}

