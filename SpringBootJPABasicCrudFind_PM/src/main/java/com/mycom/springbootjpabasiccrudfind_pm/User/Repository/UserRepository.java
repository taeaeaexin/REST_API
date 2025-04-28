package com.mycom.springbootjpabasiccrudfind_pm.User.Repository;

import com.mycom.springbootjpabasiccrudfind_pm.User.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//    @Query("select u from User u join fetch u.userRoles where u.email = :email")
    Optional<User> findByEmail(String email);
}