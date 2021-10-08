package com.cprm.userservice.repository;

import com.cprm.userservice.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails,Long> {
    Optional<UserDetails> findByEmail(String email);
}
