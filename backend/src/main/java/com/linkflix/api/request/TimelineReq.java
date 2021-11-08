package com.linkflix.api.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TimelineReq {

    private Long productId;
    private String netflixEpisodeId;
    private String startTime;

}
