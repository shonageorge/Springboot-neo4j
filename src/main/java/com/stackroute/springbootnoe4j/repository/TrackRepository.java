package com.stackroute.springbootnoe4j.repository;

import com.stackroute.springbootnoe4j.domain.Track;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;

public interface TrackRepository extends Neo4jRepository<Track,Long> {

    @Query("CREATE (t:Track) SET t.id={trackId},t.name={trackName},t.language={language} RETURN t")
    public Track createNode(Long trackId, String trackName, String language);

    @Query("MATCH (t:Track) RETURN t")
    public Collection<Track> getAllTracks();

    @Query("MATCH (Track) DETACH DELETE Track")
    public Track deleteAllNodes();

    @Query("MATCH (n:Track) WHERE n.id={trackId} DETACH DELETE n RETURN 'node deleted' ")
    public Track deleteNode(long trackId);

    @Query("MATCH (n:Track) WHERE n.id={trackId} SET n.name={name} RETURN n")
    public Track updateNode( long trackId,String name);


}
