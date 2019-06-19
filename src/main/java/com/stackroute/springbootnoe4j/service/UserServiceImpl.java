package com.stackroute.springbootnoe4j.service;

import com.stackroute.springbootnoe4j.domain.User;
import com.stackroute.springbootnoe4j.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Collection<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User create(Long userId, String userName, int age) {
        return userRepository.createNode(userId, userName, age);
    }

    @Override
    public User delete(Long userId) {
        return userRepository.deleteNode(userId);
    }

    @Override
    public User deleteAll() {
        return userRepository.deleteAllNodes();
    }

    @Override
    public User findByName(String name) {
        return userRepository.getNode(name);
    }

    @Override
    public User updateUser(long userId, String name, int age) {
        return userRepository.updateNode(userId, name, age);
    }

    @Override
    public Collection<User> getRelationship() {
        return userRepository.getRelationship();
    }

    @Override
    public User createRelationship(String userName, String trackName) {
        User user1 = userRepository.createRelationship(userName, trackName);
        return user1;
    }

    @Override
    public User createRelationshipAll() {
        User user1 = userRepository.createRelationshipAll();
        return user1;
    }

    @Override
    public User deleteRelationship() {
        return userRepository.deleteRelationship();
    }


}
