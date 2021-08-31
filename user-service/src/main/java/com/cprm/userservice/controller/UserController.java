package com.cprm.userservice.controller;

import com.cprm.userservice.VO.ResponseTemplateVO;
import com.cprm.userservice.entity.User;
import com.cprm.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getMessage(){
        return "User API working";
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        log.info("Inside getAllusers of UserController");
        return userService.getAllUsers();
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        log.info("Inside addUser of UserController");
        return userService.addUser(user);
    }

    @GetMapping("/getUserByDepartmentId/{userId}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("userId") Long userId){
        return userService.getUserWithDepartment(userId);
    }
}
