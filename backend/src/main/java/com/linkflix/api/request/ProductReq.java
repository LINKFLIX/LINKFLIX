package com.linkflix.api.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ProductReq {

    private String searchKeyword;
    private String name;

}
