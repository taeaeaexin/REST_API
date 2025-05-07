package com.mycom.springbootsecurity_jwt.user.repository;

import com.mycom.springbootsecurity_jwt.user.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    UserRole findByName(String name);
}
