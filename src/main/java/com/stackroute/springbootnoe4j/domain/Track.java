package com.stackroute.springbootnoe4j.domain;


import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Track {

    @GraphId
    private Long id;
    private String name;
    private String language;


    public Track() {
    }

    public Track(Long id, String name, String language) {
        this.id = id;
        this.name = name;
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }
}
