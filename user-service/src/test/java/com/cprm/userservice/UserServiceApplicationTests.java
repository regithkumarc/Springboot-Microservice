package com.cprm.userservice;

import com.cprm.userservice.VO.Department;
import com.cprm.userservice.entity.User;
import com.cprm.userservice.repository.UserRespository;
import com.cprm.userservice.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.verify;


@RunWith(SpringJUnit4ClassRunner.class)
class UserServiceApplicationTests {

	@Mock
	private UserRespository userRespository;
	@Mock
	private RestTemplate restTemplate;
	@InjectMocks
	private UserService userService;
	private AutoCloseable autoCloseable;

	@Test
	void contextLoads() {
	}

	@BeforeEach
	void setUp(){
		autoCloseable = MockitoAnnotations.openMocks(this);
		//userService = new UserService();
	}

	@Test
	public void getAllUsers(){
		userService.getAllUsers();
		verify(userRespository).findAll();
	}

	@Test
	public void addUser() {

		User user = userService.addUser(getUserDetails());
		verify(userRespository).save(getUserDetails());
		boolean exists = userRespository.existsById(getUserDetails().getUserId());
		System.out.println(exists);
	}

	@Test
	public void getUserWithDepartment() {
		//addUser();
		Mockito.when(userRespository.findByUserId(1L)).thenReturn(getUserDetails());
		userService.getUserWithDepartment(getUserDetails().getUserId());
		verify(userRespository).findByUserId(getUserDetails().getUserId());
	}

	User getUserDetails(){
		User user = new User(1L,"regith","c",1L);
		return  user;
	}

	@Test
	@Disabled
	void dummyTest(){

	}

	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}

}
