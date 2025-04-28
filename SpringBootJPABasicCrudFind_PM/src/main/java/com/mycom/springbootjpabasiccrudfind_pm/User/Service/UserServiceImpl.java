package com.mycom.springbootjpabasiccrudfind_pm.User.Service;

import com.mycom.springbootjpabasiccrudfind_pm.User.Dto.UserDto;
import com.mycom.springbootjpabasiccrudfind_pm.User.Dto.UserResultDto;
import com.mycom.springbootjpabasiccrudfind_pm.User.Entity.User;
import com.mycom.springbootjpabasiccrudfind_pm.User.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserResultDto register(UserDto userDto) {
        UserResultDto userResultDto = new UserResultDto();
        return userResultDto;
    }

    @Override
    public UserResultDto login(String email, String password) {
        UserResultDto userResultDto = new UserResultDto();
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            if(user.getPassword().equals(password)){
                UserDto userDto = UserDto.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .build();
                userResultDto.setUserDto(userDto);
                userResultDto.setResult("success");
            }else{
                userResultDto.setResult("fail");
            }
        }else{
            userResultDto.setResult("notfound");
        }
        return userResultDto;
    }
}
