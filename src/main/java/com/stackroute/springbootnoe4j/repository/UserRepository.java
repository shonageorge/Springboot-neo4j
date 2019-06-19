package com.stackroute.springbootnoe4j.repository;

import com.stackroute.springbootnoe4j.domain.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


public interface UserRepository extends Neo4jRepository<User,Long> {

    @Query("CREATE (u:User) SET u.id={userId},u.name={userName},u.age={age} RETURN u")
    public User createNode(long userId, String userName, int age);

    @Query("MATCH (n:User) RETURN n")
    public Collection<User> getAllUsers();

    @Query("MATCH (n:User) WHERE n.id={userId} DETACH DELETE n RETURN 'node deleted' ")
    public User deleteNode(long userId);

    @Query("MATCH (User) DETACH DELETE User")
    public User deleteAllNodes();

    @Query("MATCH (u:User) WHERE u.name={userName} RETURN u")
    public User getNode(@Param("userName") String userName);

    @Query("MATCH (n:User) WHERE n.id={userId} SET n.name={name},n.age={age} RETURN n")
    public User updateNode( long userId,String name,int age);

   @Query("CREATE (u:User),(m:Track) SET u.name={userName},m.name={trackName} CREATE (m)-[:LIKES]->(u);")
    public User createRelationship(String userName,String trackName);

    @Query( "MATCH (u:User),(m:Track)  CREATE (m)-[:LIKES]->(u);")
    public User createRelationshipAll();

    @Query( "MATCH (User)-[r:LIKES]->(Track) DELETE r;")
    public User deleteRelationship();

    @Query("MATCH (u:User)<-[r:LIKED]-(m:Track) RETURN u,r,m")
    public Collection<User> getRelationship();
}
