package com.mycom.springbootsecurity_jwt.auth.dto;

import com.mycom.springbootsecurity_jwt.user.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginResultDto {
    private String rsult;
    private String token;
    private UserDto userDto;
}
