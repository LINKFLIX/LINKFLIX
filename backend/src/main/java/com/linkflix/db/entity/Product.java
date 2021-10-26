package com.linkflix.db.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name="products")
@Getter
@Setter
public class Product extends BaseEntity {

    @Column(nullable = false)
    private String searchKeyword;
    private String name;
    private String imagePath;

    public Product() {}

    @Builder
    public Product(String searchKeyword, String name, String imagePath) {
        this.searchKeyword = searchKeyword;
        this.name = name;
        this.imagePath = imagePath;
    }
}
