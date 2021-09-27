package com.cprm.userservice.feign;

import com.cprm.userservice.entity.User;
import com.cprm.userservice.entity.UserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@org.springframework.cloud.openfeign.FeignClient(value = "feign-rest-api", url = "http://DEPARTMENT-SERVICE/departments/getDepartment/")
public interface FeignClient {

    @GetMapping("/getAllUsers")
    ResponseEntity<UserDetails> getAllUsers();
    @GetMapping("/getUserById/{id}")
    UserDetails getUserById(@PathVariable("id") Long id);
    @PostMapping("/addUser")
    UserDetails addUser(@RequestBody UserDetails userDetails);
    @PutMapping("/updateUser")
    ResponseEntity<UserDetails> updateUser(@RequestBody UserDetails userDetails);
    @PutMapping("/updateUserById/{id}")
    ResponseEntity<UserDetails> updateUserById(@PathVariable("id") Long id);
    @DeleteMapping("/deleteByUserId/{id}")
    ResponseEntity<UserDetails> deleteUserById(@PathVariable("id") Long id);
}
