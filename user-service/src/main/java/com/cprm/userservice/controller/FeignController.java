package com.cprm.userservice.controller;

import com.cprm.userservice.entity.UserDetails;
import com.cprm.userservice.exception.ErrorMessages;
import com.cprm.userservice.exception.UserServiceException;
import com.cprm.userservice.feign.FeignClient;
import com.cprm.userservice.repository.UserDetailsRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/userDetails")
public class FeignController {

    @Autowired
    Environment environment;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    FeignClient feignClient;

    @GetMapping("/getPort")
    public String getPort(){
        return environment.getProperty("local.server.port");
    }

    @PostMapping("/addUser")
    public ResponseEntity<UserDetails> addUser(@RequestBody @Valid UserDetails userDetails) throws NotFoundException{
        UserDetails userDetails1 = userDetailsRepository.save(userDetails);
        if(userDetails1 == null)
            throw new UserServiceException(ErrorMessages.DATA_NOT_ADDED.getErrorMessage());
        return new ResponseEntity<UserDetails>(userDetails1,HttpStatus.CREATED);

    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<UserDetails> getAllUsers(){
        return feignClient.getAllUsers();
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<UserDetails> getUserById(@PathVariable("id") Long id) throws NotFoundException {
        Optional<UserDetails> userDetails = userDetailsRepository.findById(id);
        if(!userDetails.isPresent())
            throw new UserServiceException(ErrorMessages.NO_DATA_FOUND.getErrorMessage());
        //return ResponseEntity.status(HttpStatus.OK).body(userDetails);
        return new ResponseEntity<UserDetails>(userDetails.get(),HttpStatus.OK);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<UserDetails> updateUser(@RequestBody @Valid UserDetails userDetails){
        UserDetails userDetails1 = userDetailsRepository.save(userDetails);
        if(userDetails1 == null)
            throw new UserServiceException(ErrorMessages.DATA_NOT_ADDED.getErrorMessage());
        return new ResponseEntity<UserDetails>(userDetails1,HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteUserById/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id){
        userDetailsRepository.deleteById(id);
        boolean exists = userDetailsRepository.existsById(id);
        if(exists)
            throw new UserServiceException(ErrorMessages.DATA_NOT_REMOVED.getErrorMessage());
        return new ResponseEntity<String>("User Id is removed Successfully - " + id,HttpStatus.OK);
    }
}
