package com.linkflix.api.service;

import com.linkflix.api.response.TimelineRes;
import com.linkflix.db.entity.Timeline;

import java.util.List;

public interface TimelineService {

    TimelineRes selectTimeline(Long id);
    List<Timeline> getTimelineByNetflixEpisodeId(String netflixEpisodeId);

}
