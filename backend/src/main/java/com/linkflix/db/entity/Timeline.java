package com.linkflix.db.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
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
    private String endTime;

    public Timeline() {}
    public Timeline(Product product, String netflixEpisodeId, String startTime, String endTime) {
        this.product = product;
        this.netflixEpisodeId = netflixEpisodeId;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
