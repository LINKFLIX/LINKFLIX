package com.linkflix.db.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity(name="timelines")
@Getter
@Setter
public class Timeline extends BaseEntity {

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="productId", nullable = false)
    Product product;

    private String netflixEpisodeId;
    private String startTime;

    public Timeline() {}
    public Timeline(Product product, String netflixEpisodeId, String startTime) {
        this.product = product;
        this.netflixEpisodeId = netflixEpisodeId;
        this.startTime = startTime;
    }
}
