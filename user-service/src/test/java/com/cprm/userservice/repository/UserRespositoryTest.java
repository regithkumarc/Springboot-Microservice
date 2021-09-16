package com.cprm.userservice.repository;

import com.cprm.userservice.VO.Department;
import com.cprm.userservice.VO.ResponseTemplateVO;
import com.cprm.userservice.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserRespositoryTest {

    @Autowired
    private UserRespository userRespository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByUserId() {

        User user = new User(1L,"regith","kumar",1L);
        userRespository.save(user);

        User existsUser = userRespository.findByUserId(user.getUserId());
        assertThat(existsUser.getUserId()).isEqualTo(1L);

        userRespository.delete(user);
        boolean u1 = userRespository.existsById(user.getUserId());
        assertThat(u1).isFalse();
    }

    @AfterEach
    void tearDown() {
    }
}