package com.linkflix.api.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductUpdateReq {

    private Long id;
    private String searchKeyword;
    private String name;

}
