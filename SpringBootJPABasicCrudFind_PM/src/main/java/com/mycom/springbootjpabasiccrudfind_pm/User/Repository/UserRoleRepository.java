package com.mycom.springbootjpabasiccrudfind_pm.User.Repository;

import com.mycom.springbootjpabasiccrudfind_pm.User.Entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    UserRole findByName(String name);
}
