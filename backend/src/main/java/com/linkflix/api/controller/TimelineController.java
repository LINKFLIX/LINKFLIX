package com.linkflix.api.controller;

import com.linkflix.api.request.TimelineReq;
import com.linkflix.api.response.TimelineRes;
import com.linkflix.api.service.TimelineService;
import com.linkflix.db.entity.Timeline;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "타임라인(Timeline) API", tags = {"Timeline"})
@CrossOrigin
@RestController
@RequestMapping("/timelines")
@Slf4j
public class TimelineController {

    @Autowired
    TimelineService timelineService;

    @PostMapping("/regist")
    public ResponseEntity<Timeline> registTimeline(@RequestBody TimelineReq timelineReq) {
        log.info("POST /timelines/regist");

        Timeline timeline = timelineService.saveTimeline(timelineReq);
        return ResponseEntity.status(200).body(timeline);
    }

    @GetMapping("/{netflixEpisodeId}")
    public ResponseEntity<List<TimelineRes>> getTimeline(@PathVariable String netflixEpisodeId) {
        log.info("GET /timelines/" + netflixEpisodeId);

        List<TimelineRes> timelineRes = new ArrayList<TimelineRes>();
        List<Timeline> timelines = timelineService.getTimelineByNetflixEpisodeId(netflixEpisodeId);
        for(Timeline timeline : timelines) {
            timelineRes.add(timelineService.selectTimeline(timeline.getId()));
        }
    return ResponseEntity.status(200).body(timelineRes);
    }
}
