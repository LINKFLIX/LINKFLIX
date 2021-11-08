package com.linkflix.api.response;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("ProductResponse")
public class ProductRes {

    Long id;
    String searchKeyword;
    String name;
    String imageName;

}
