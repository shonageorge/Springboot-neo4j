package com.stackroute.springbootnoe4j.service;

import com.stackroute.springbootnoe4j.domain.Track;
import com.stackroute.springbootnoe4j.domain.User;
import com.stackroute.springbootnoe4j.repository.TrackRepository;
import com.stackroute.springbootnoe4j.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TrackServiceImpl implements TrackService {

    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }


    @Override
    public Track create(Long trackId, String trackName, String language) {
        return trackRepository.createNode(trackId, trackName, language);
    }

    @Override
    public Collection<Track> getAllTracks() {
        return trackRepository.getAllTracks();
    }

    @Override
    public Track deleteAll() {
        return trackRepository.deleteAllNodes();
    }

    @Override
    public Track delete(Long trackId) {
        return trackRepository.deleteNode(trackId);
    }

    @Override
    public Track updateTrack(long trackId, String name) {
        return trackRepository.updateNode(trackId, name);
    }
}
