package com.mycom.springbootsecurity_jwt.user.dto;

import com.mycom.springbootsecurity_jwt.user.entity.UserRole;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String password;

    private List<UserRole> roles;
}
