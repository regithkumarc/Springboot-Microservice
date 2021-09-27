package com.cprm.userservice.controller;

import com.cprm.userservice.entity.ErrorHandlerVO;
import com.cprm.userservice.exception.ErrorMessages;
import com.cprm.userservice.exception.UserServiceException;
import com.cprm.userservice.repository.ErrorHandlerRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/error")
@Validated
public class ErrorHandlerResponseEntityController {

    @Autowired
    public ErrorHandlerRepository errorHandlerRepository;

    @PostMapping("/addError")
    public ResponseEntity<ErrorHandlerVO> addError(@RequestBody ErrorHandlerVO errorHandlerVO) throws Exception{

        if(errorHandlerVO.getEmail().isEmpty())
            throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELDS.getErrorMessage());

        errorHandlerRepository.save(errorHandlerVO);

        return new ResponseEntity<ErrorHandlerVO>(errorHandlerVO, HttpStatus.OK);
    }

    @RequestMapping(value  = "/addErrorWithValid")
    public ResponseEntity<ErrorHandlerVO> addErrorWithValid(@RequestBody @Valid ErrorHandlerVO errorHandlerVO) {
        //errorHandlerRepository.save(errorHandlerVO);
        return new ResponseEntity<ErrorHandlerVO>(errorHandlerVO, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ErrorHandlerVO> add(@RequestBody @Valid ErrorHandlerVO errorHandlerVO) throws NotFoundException {
        errorHandlerRepository.save(errorHandlerVO);
        Optional<ErrorHandlerVO> errorHandlerVO1 = errorHandlerRepository.findById(errorHandlerVO.getId());
        if(!errorHandlerVO1.isPresent())
            throw new UserServiceException(ErrorMessages.NO_DATA_FOUND.getErrorMessage());
        return new ResponseEntity<ErrorHandlerVO>(errorHandlerVO,HttpStatus.CREATED);
    }

    @GetMapping("/getSingle/{id}")
    public ResponseEntity<Object> get(@PathVariable Long id) throws NotFoundException{

       Optional<ErrorHandlerVO> errorHandlerVO =  errorHandlerRepository.findById(id);

       if(!errorHandlerVO.isPresent()) {
           throw new UserServiceException(ErrorMessages.NO_DATA_FOUND.getErrorMessage());
       }else {
           return ResponseEntity.status(HttpStatus.OK).body(errorHandlerVO);
       }
    }
}
