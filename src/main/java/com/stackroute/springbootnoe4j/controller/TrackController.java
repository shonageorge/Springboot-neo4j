package com.stackroute.springbootnoe4j.controller;

import com.stackroute.springbootnoe4j.domain.Track;
import com.stackroute.springbootnoe4j.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping(value = "v1/api")
public class TrackController {

    TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    //Mapping to get all tracks
    @GetMapping("/tracks")
    public Collection<Track> getAllTracks() {
        return trackService.getAllTracks();
    }


    //To create new track
    @PostMapping("/newTrack")
    public Track saveTrack(@RequestBody Track track) {
        Track track1 = trackService.create(track.getId(), track.getName(), track.getLanguage());
        return track1;
    }

    //To delete all the tracks
    @DeleteMapping("/trackGone")
    public String deleteAllTrack() {
        trackService.deleteAll();
        return "deletedAll";
    }

    //To delete track by id
    @DeleteMapping("/track/{id}")
    public Track delete(@PathVariable Long id) {
        return trackService.delete(id);
    }

    //To update track by id
    @PutMapping("/track/{id}/{name}")
    public Track update(@PathVariable long id, @PathVariable String name) {
        return trackService.updateTrack(id, name);
    }
}
