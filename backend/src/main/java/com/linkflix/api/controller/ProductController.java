package com.linkflix.api.controller;

import com.linkflix.api.response.ProductRes;
import com.linkflix.api.service.ProductService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Api(value = "상품(Product) API", tags = {"Product"})
@CrossOrigin
@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(value = "/regist")
    public ResponseEntity<ProductRes> registProduct(@RequestPart MultipartFile file) throws Exception {
        ProductRes productRes = new ProductRes();

        log.info("POST /prdoucts/regist");
        return ResponseEntity.status(200).body(productRes);
    }
}

