package com.linkflix.db.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Time;

@Entity(name="timelines")
@Getter
@Setter
public class Timeline extends BaseEntity {

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="productId", nullable = false)
    Product product;

    private String netflixEpisodeId;
    private Time startTime;
    private Time endTime;

}
