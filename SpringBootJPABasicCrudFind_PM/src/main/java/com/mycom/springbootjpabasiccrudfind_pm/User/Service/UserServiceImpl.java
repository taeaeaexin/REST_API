package com.mycom.springbootjpabasiccrudfind_pm.User.Service;

import com.mycom.springbootjpabasiccrudfind_pm.User.Dto.UserDto;
import com.mycom.springbootjpabasiccrudfind_pm.User.Dto.UserResultDto;
import com.mycom.springbootjpabasiccrudfind_pm.User.Entity.User;
import com.mycom.springbootjpabasiccrudfind_pm.User.Entity.UserRole;
import com.mycom.springbootjpabasiccrudfind_pm.User.Repository.UserRepository;
import com.mycom.springbootjpabasiccrudfind_pm.User.Repository.UserRoleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    @Override
    @Transactional
    public UserResultDto register(UserDto userDto) {
        UserResultDto userResultDto = new UserResultDto();

        try {
            UserRole userRole = new UserRole();
            userRole.setName("test_user_role");

            User user = User.builder()
                    .name(userDto.getName())
                    .email(userDto.getEmail())
                    .password(userDto.getPassword())
                    .build();

            List<UserRole> userRoles = List.of(userRole);
            user.setUserRoles(userRoles);

            userRoleRepository.save(userRole);
            userRepository.save(user);

            UserDto savedUserDto = UserDto.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .email(user.getEmail())
                    .build();
            userResultDto.setUserDto(savedUserDto);
            userResultDto.setResult("success");

        } catch (Exception e) {
            e.printStackTrace();
            userResultDto.setResult("fail");
        }

        return userResultDto;
//        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
//
//        if(optionalUser.isEmpty()) {
//            User user = User.builder()
//                    .name(userDto.getName())
//                    .email(userDto.getEmail())
//                    .password(userDto.getPassword())
//                    .build();
//            userRepository.save(user);
//            UserDto savedUserDto = UserDto.builder()
//                    .id(user.getId())
//                    .name(user.getName())
//                    .email(user.getEmail())
//                    .build();
//            userResultDto.setUserDto(savedUserDto);
//            userResultDto.setResult("success");
//        }else userResultDto.setResult("fail");
//        return userResultDto;
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
