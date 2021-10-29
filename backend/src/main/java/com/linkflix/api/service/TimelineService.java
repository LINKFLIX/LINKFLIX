package com.linkflix.api.service;

import com.linkflix.api.request.TimelineReq;
import com.linkflix.api.request.TimelineUpdateReq;
import com.linkflix.api.response.TimelineRes;
import com.linkflix.db.entity.Timeline;

import java.util.List;

public interface TimelineService {

    TimelineRes selectTimeline(Long id);
    List<Timeline> getTimelineByNetflixEpisodeId(String netflixEpisodeId);
    Timeline saveTimeline(TimelineReq timelineReq);
    TimelineRes updateTimeline(TimelineUpdateReq timelineReq);
    void deleteTimeline(Long timelineId);

}
