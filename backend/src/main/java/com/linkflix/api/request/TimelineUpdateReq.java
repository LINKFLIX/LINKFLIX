package com.linkflix.api.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TimelineUpdateReq {

    private Long timelineId;
    private Long productId;
    private String netflixEpisodeId;
    private String startTime;
    private String endTime;

}
