package com.linkflix.api.response;

import com.linkflix.db.entity.Product;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@ApiModel("TimelineResponse")
public class TimelineRes {

    Long id;
    Product product;
    Time startTime;
    Time endTime;

}
