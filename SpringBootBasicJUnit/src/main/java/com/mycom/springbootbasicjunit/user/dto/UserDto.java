package com.mycom.springbootbasicjunit.user.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String password;

    private Map<Integer, String> roles;
}
