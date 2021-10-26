package com.linkflix.api.controller;

import com.linkflix.api.request.ProductReq;
import com.linkflix.api.service.ProductService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api(value = "상품(Product) API", tags = {"Product"})
@CrossOrigin
@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(value = "/regist")
    public ResponseEntity<String> registProduct(@RequestParam("file") MultipartFile file, ProductReq productReq) throws Exception {
        log.info("POST /prdoucts/regist");

        String uuid = productService.saveProduct(file, productReq);
        return ResponseEntity.status(200).body(uuid);
    }
}

