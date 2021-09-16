package com.cprm.userservice.service;

import com.cprm.userservice.VO.Department;
import com.cprm.userservice.VO.ResponseTemplateVO;
import com.cprm.userservice.entity.User;
import com.cprm.userservice.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserRespository userRespository;
    @Autowired
    RestTemplate restTemplate;

    //String DEPARTMENT_URL = "http://localhost:8089/getDepartment/";
    String DEPARTMENT_URL = "http://DEPARTMENT-SERVICE/departments/getDepartment/";

    public List<User> getAllUsers(){
        return userRespository.findAll();
    }

    public User addUser(User user) {
        return userRespository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        User user = userRespository.findByUserId(userId);

        Department department = restTemplate.getForObject(DEPARTMENT_URL+ user.getDepartmentId(), Department.class);
        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);
        return responseTemplateVO;
    }
}
