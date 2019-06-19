package com.stackroute.springbootnoe4j.controller;

import com.stackroute.springbootnoe4j.domain.User;
import com.stackroute.springbootnoe4j.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1")

public class UserController {


    public UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    //To get all users
    @GetMapping("/user")
    public Collection<User> getAllUser() {
        return userService.getAllUsers();
    }


    //To create new user
    @PostMapping("/newUser")
    public User saveUser(@RequestBody User user) {
        User user1 = userService.create(user.getId(), user.getName(), user.getAge());
        return user1;
    }

    //To delete user by id
    @DeleteMapping("/user/{id}")
    public User delete(@PathVariable Long id) {
        return userService.delete(id);
    }


    //To delete all users
    @DeleteMapping("/userGone")
    public String deleteAll() {
        userService.deleteAll();
        return "deletedAll";
    }

    //To find user by name
    @GetMapping("/{name}")
    public User findByName(@PathVariable String name) {
        return userService.findByName(name);
    }

    //To update user by id
    @PutMapping("/{id}")
    public User update(@PathVariable long id, @RequestBody User user) {
        return userService.updateUser(id, user.getName(), user.getAge());
    }

    //To create relationship
    @PostMapping("/newRelationship/{userName}/{trackName}")
    public User relationship(@PathVariable String userName, @PathVariable String trackName) {
        User user1 = userService.createRelationship(userName, trackName);
        return user1;
    }

    //To create relationship for all nodes
    @PostMapping("/allRelationship")
    public User relationshipAll() {
        User user1 = userService.createRelationshipAll();
        return user1;
    }

    //To delete relationship
    @DeleteMapping("/deleteRelationship")
    public User relationshipdelete() {
        User user1 = userService.deleteRelationship();
        return user1;
    }

    //To get relationship
    @GetMapping("/relationship")
    public Collection<User> getRelationship() {
        return userService.getRelationship();
    }

}
