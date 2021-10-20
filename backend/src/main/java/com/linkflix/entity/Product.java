package com.linkflix.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name="products")
@Getter
@Setter
public class Product extends BaseEntity {

    @Column(nullable = false)
    private String name;

    private String imagePath;

}
