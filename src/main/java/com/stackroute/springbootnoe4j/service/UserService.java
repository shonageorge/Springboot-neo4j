package com.stackroute.springbootnoe4j.service;


import com.stackroute.springbootnoe4j.domain.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface UserService {

    public Collection<User> getAllUsers();
    public User create(Long userId, String userName, int age);
    public User delete(Long userId);
    public User deleteAll();
    public User findByName(String name);
    public User updateUser(long userId,String name,int age);
    public Collection<User> getRelationship();
    public User createRelationship(String userName, String trackName);
    public User createRelationshipAll();
    public User deleteRelationship();
}
