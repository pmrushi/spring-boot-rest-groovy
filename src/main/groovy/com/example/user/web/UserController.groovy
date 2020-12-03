package com.example.user.web

import groovy.transform.ToString
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
class UserController {

    def usersList = []

    @GetMapping
    List<User> getUsers() {
        //def user1 = new User([firstName: "John", lastName: "Carter"])
        //def user2 = new User([firstName: "Rushi", lastName: "Pamu"])
        //def users = [user1, user2]
        //println(user1.toString())
        return usersList
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable int userId) {
        println(userId)
        def user = usersList.find {it.id == userId}
        println(user.toString())
        return user
        //return new User([firstName: "John", lastName: "Carter"])
    }

    @PostMapping
    User saveUser(@RequestBody User user) {
        println(user.toString())
        usersList.add(user)
        return user
        //return new User([firstName: "John", lastName: "Carter"])
    }

    @DeleteMapping("/{userId}")
    User deleteUser(@PathVariable int userId) {
        def user = usersList.find {it.id == userId}
        usersList.remove(user)
        return user
    }
}

@ToString
class User {
    int id
    def firstName
    def lastName
}
