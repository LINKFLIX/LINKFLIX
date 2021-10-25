package com.linkflix.api.controller;

import com.linkflix.api.response.TimelineRes;
import com.linkflix.api.service.TimelineService;
import com.linkflix.db.entity.Timeline;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "타임라인(Timeline) API", tags = {"Timeline"})
@CrossOrigin
@RestController
@RequestMapping("/timelines")
public class TimelineController {

    @Autowired
    TimelineService timelineService;

    @GetMapping("/{netflixEpisodeId}")
    public ResponseEntity<List<TimelineRes>> getTimeline(@PathVariable String netflixEpisodeId) {
        List<TimelineRes> timelineRes = new ArrayList<TimelineRes>();
        List<Timeline> timelines = timelineService.getTimelineByNetflixEpisodeId(netflixEpisodeId);
        for(Timeline timeline : timelines) {
            timelineRes.add(timelineService.selectTimeline(timeline.getId()));
        }
    return ResponseEntity.status(200).body(timelineRes);
    }
}
