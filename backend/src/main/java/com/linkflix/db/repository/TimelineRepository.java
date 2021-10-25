package com.linkflix.db.repository;

import com.linkflix.db.entity.Timeline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimelineRepository extends JpaRepository<Timeline, Long> {

    List<Timeline> findByNetflixEpisodeId(String netflixEpisodeId);

}
