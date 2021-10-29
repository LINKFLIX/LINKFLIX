package com.linkflix.db.repository;

import com.linkflix.db.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findBySearchKeyword(String searchKeyword);
    Product findByImagePath(Long productId);
}
