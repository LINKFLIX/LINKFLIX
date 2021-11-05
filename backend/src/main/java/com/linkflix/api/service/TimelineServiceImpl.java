package com.linkflix.api.service;

import com.linkflix.api.request.TimelineReq;
import com.linkflix.api.request.TimelineUpdateReq;
import com.linkflix.api.response.TimelineRes;
import com.linkflix.db.entity.Product;
import com.linkflix.db.entity.Timeline;
import com.linkflix.db.repository.ProductRepository;
import com.linkflix.db.repository.TimelineRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service("timelineService")
@RequiredArgsConstructor
@Slf4j
public class TimelineServiceImpl implements TimelineService{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    TimelineRepository timelineRepository;

    @Override
    public TimelineRes selectTimeline(Long id) {
        Optional<Timeline> timeline = timelineRepository.findById(id);
        TimelineRes timelineRes = new TimelineRes();
        timelineRes.setId(id);
        timelineRes.setProduct(timeline.get().getProduct());
        timelineRes.setStartTime(timeline.get().getStartTime());
        return timelineRes;
    }

    @Override
    public List<TimelineRes> sortTimeline(List<TimelineRes> timelineRes) {
       Collections.sort(timelineRes, new Comparator<TimelineRes>() {
           @Override
           public int compare(TimelineRes o1, TimelineRes o2) {
               int num = o1.getStartTime().length() - o2.getStartTime().length();
               return num == 0 ? o1.getStartTime().compareTo(o2.getStartTime()) : o1.getStartTime().length() - o2.getStartTime().length();
           }
       });

        return timelineRes;
    }

    @Override
    public List<Timeline> getTimelineByNetflixEpisodeId(String netflixEpisodeId) {
        List<Timeline> timelines = timelineRepository.findByNetflixEpisodeId(netflixEpisodeId);
        return timelines;
    }

    @Override
    public Timeline saveTimeline(TimelineReq timelineReq) {
       Product product = new Product();
       product.setId(timelineReq.getProductId());
       return timelineRepository.save(new Timeline(product, timelineReq.getNetflixEpisodeId(), timelineReq.getStartTime()));
    }

    @Override
    @Transactional
    public TimelineRes updateTimeline(TimelineUpdateReq timelineReq) {
        Timeline timeline = timelineRepository.findById(timelineReq.getTimelineId()).get();
        timeline.setNetflixEpisodeId(timelineReq.getNetflixEpisodeId());
        timeline.setStartTime(timelineReq.getStartTime());

       TimelineRes timelineRes = selectTimeline(timelineReq.getTimelineId());
       return timelineRes;
    }

    @Override
    public void deleteTimeline(Long timelineId) {
        timelineRepository.deleteById(timelineId);
    }

}
