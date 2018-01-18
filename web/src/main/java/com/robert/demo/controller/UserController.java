package com.robert.demo.controller;


import com.robert.demo.repository.UserRepository;
import com.robert.demo.repository.domain.UserInfo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/user")
public class UserController {

    private final UserRepository mUserRepository;

    public UserController(UserRepository userRepository) {
        mUserRepository = userRepository;
    }

    @PostMapping
    public UserInfo saveUser(@RequestParam String userName){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        boolean success = mUserRepository.saveUser(userInfo);
        return userInfo;
    }

    @GetMapping
    public List<UserInfo> getUser(){
        return mUserRepository.getUser();
    }

}
