package com.linkflix.api.controller;

import com.linkflix.api.request.TimelineReq;
import com.linkflix.api.request.TimelineUpdateReq;
import com.linkflix.api.response.TimelineRes;
import com.linkflix.api.service.TimelineService;
import com.linkflix.common.BaseResponse;
import com.linkflix.db.entity.Timeline;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Api(value = "타임라인(Timeline) API", tags = {"Timeline"})
@CrossOrigin
@RestController
@RequestMapping("/timelines")
@Slf4j
public class TimelineController {

    @Autowired
    TimelineService timelineService;

    @PostMapping(value="/regist")
    public ResponseEntity<Timeline> registTimeline(@RequestBody TimelineReq timelineReq) {
        log.info("POST /timelines/regist/ timelineReq: " + timelineReq);

        Timeline timeline = timelineService.saveTimeline(timelineReq);
        return ResponseEntity.status(200).body(timeline);
    }

    @GetMapping(value="/{netflixEpisodeId}")
    public ResponseEntity<List<TimelineRes>> getTimeline(@PathVariable String netflixEpisodeId) {
        log.info("GET /timelines/" + netflixEpisodeId);

        List<TimelineRes> timelineRes = new ArrayList<TimelineRes>();
        List<Timeline> timelines = timelineService.getTimelineByNetflixEpisodeId(netflixEpisodeId);
        for(Timeline timeline : timelines) {
            timelineRes.add(timelineService.selectTimeline(timeline.getId()));
        }
        timelineRes = timelineService.sortTimeline(timelineRes);
    return ResponseEntity.status(200).body(timelineRes);
    }

    @PatchMapping(value="/update")
    public ResponseEntity<TimelineRes> updateTimeline(@RequestBody TimelineUpdateReq timelineReq) {
        log.info("PATCH /timelines/update/ timelineReq: " + timelineReq);

        TimelineRes timelineRes = timelineService.updateTimeline(timelineReq);
        return ResponseEntity.status(200).body(timelineRes);
    }

    @DeleteMapping(value="/delete/{timelineId}")
    public ResponseEntity<? extends BaseResponse> deleteTimeline(@PathVariable Long timelineId) {
        log.info("DELETE /timelines/delete/" + timelineId);

        timelineService.deleteTimeline(timelineId);
        return ResponseEntity.status(200).body(BaseResponse.of(200, "Success"));
    }

}
