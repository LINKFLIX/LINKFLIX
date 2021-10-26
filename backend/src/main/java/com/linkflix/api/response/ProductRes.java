package com.linkflix.api.response;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@ApiModel("ProductResponse")
public class ProductRes {

    Long id;
    String name;
    String imagePath;
    Timestamp createAt;
    Timestamp updateAt;

}
