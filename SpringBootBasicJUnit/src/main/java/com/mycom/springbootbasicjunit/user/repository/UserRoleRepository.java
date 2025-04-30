package com.mycom.springbootbasicjunit.user.repository;

import com.mycom.springbootbasicjunit.user.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    // crud 자동 구현
    // 이름으로 검색, 영속화
    UserRole findByName(String name);
}
