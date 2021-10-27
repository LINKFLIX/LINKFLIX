package com.linkflix.common;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("BaseResponse")
public class BaseResponse {

    String message;
    Integer statusCode;

    private void message(String message) {
        this.message = message;
    }

    private void statusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public static BaseResponse of(Integer statusCode, String message) {
        BaseResponse br = new BaseResponse();
        br.statusCode(statusCode);
        br.message(message);
        return br;
    }

}
