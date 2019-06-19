package com.stackroute.springbootnoe4j.service;

import com.stackroute.springbootnoe4j.domain.Track;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public interface TrackService {
    public Track create(Long trackId, String trackName, String language);
    public Collection<Track> getAllTracks();
    public Track deleteAll();
    public Track delete(Long trackId);
    public Track updateTrack(long trackId,String name);
}
