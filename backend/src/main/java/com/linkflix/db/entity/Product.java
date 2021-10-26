package com.linkflix.db.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity(name="products")
@Getter
@Setter
public class Product extends BaseEntity {

    @Column(nullable = false)
    private String name;
    private String imagePath;

}
