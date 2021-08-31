package com.cprm.SpringBootCRUD.repository;

import com.cprm.SpringBootCRUD.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
