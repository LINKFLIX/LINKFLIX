package com.linkflix.api.controller;

import com.linkflix.api.service.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "상품(Product) API", tags = {"Product"})
@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {







}
