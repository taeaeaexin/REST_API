package com.mycom.myapp.user.repository;

import com.mycom.myapp.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // login
    // #1, #2
//    Optional<User> findByEmail(String email);

    // #3
    // jpql
    @Query("select u from User u join fetch u.userRoles where u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);
}