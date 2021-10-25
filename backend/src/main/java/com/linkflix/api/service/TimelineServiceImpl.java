package com.linkflix.api.service;

import com.linkflix.api.response.TimelineRes;
import com.linkflix.db.entity.Timeline;
import com.linkflix.db.repository.TimelineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("timelineService")
@RequiredArgsConstructor
public class TimelineServiceImpl implements TimelineService{

    @Autowired
    TimelineRepository timelineRepository;

    @Override
    public TimelineRes selectTimeline(Long id) {
        Optional<Timeline> timeline = timelineRepository.findById(id);
        TimelineRes timelineRes = new TimelineRes();
        timelineRes.setId(id);
        timelineRes.setProduct(timeline.get().getProduct());
        timelineRes.setStartTime(timeline.get().getStartTime());
        timelineRes.setEndTime(timeline.get().getEndTime());
        return timelineRes;
    }

    @Override
    public List<Timeline> getTimelineByNetflixEpisodeId(String netflixEpisodeId) {
        List<Timeline> timelines = timelineRepository.findByNetflixEpisodeId(netflixEpisodeId);
        return timelines;
    }
}
