package com.linkflix.api.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ProductReq {

    private String name;
    private String searchKeyword;
}
