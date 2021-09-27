package com.cprm.userservice.repository;

import com.cprm.userservice.entity.ErrorHandlerVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorHandlerRepository extends JpaRepository<ErrorHandlerVO,Long> {
}
