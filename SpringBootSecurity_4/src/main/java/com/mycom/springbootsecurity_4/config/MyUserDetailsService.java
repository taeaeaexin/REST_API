package com.mycom.springbootsecurity_4.config;

import com.mycom.springbootsecurity_4.user.entity.User;
import com.mycom.springbootsecurity_4.user.entity.UserRole;
import com.mycom.springbootsecurity_4.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService{
//  // DI
//  private final PasswordEncoder passwordEncoder;

    // 기본 form ui 로그인 그대로 ( 우리가 별도의 login 페이지를 제공 X )
    // username, password 가 user / console password 사용 X <= UserDetailsService 를 제공하므로
    // form ui 에 사용자가 입력한 username 값이 loadUserByUsername() 파라미터로 전달 (username)
    // DB 를 통해서 ( JPA 경우 UserRepository 를 거쳐서 ) username 으로 select username, password 를 가져와서
    // UserDetails 구현 객체를 만들어서 return 해 줘야 한다.
    // UserDetails 구현 객체는 우선 Spring security 에서 제공하는 org.springframework.security.core.userdetails.User 를 사용

    // ROLE 고려 X
//  @Override
//  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//      // PasswordEncoder 객체 구현 클래스
//      System.out.println(passwordEncoder.getClass());
//
//      if( "dskim".equals(username) ) {
//          return User.builder()
//                  .username("dskim")
//                  .password(passwordEncoder.encode("1234"))
//                  .build();
//      }else {
//          throw new UsernameNotFoundException("User not found");
//      }
//  }

    // ROLE 고려 O
//  @Override
//  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//      // PasswordEncoder 객체 구현 클래스
//      System.out.println(passwordEncoder.getClass());
//
//
//
//
//      if( "dskim".equals(username) ) {
//          return User.builder()
//                  .username("dskim")
//                  .password(passwordEncoder.encode("1234"))
//                  .roles("CUSTOMER")
//                  .build();
//      }else {
//          throw new UsernameNotFoundException("User not found");
//      }
//  }


    private final UserRepository userRepository;

    // dskim/1234 => User Entity 를 이용한 UserDetails
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//
//        Optional<User> optionalUser = userRepository.findByEmail(email);
//
//
//        if( optionalUser.isPresent() ) {
//            User user = optionalUser.get();
//            List<UserRole> listUserRole = user.getUserRoles();
//            String[] rolesStrArray = listUserRole.stream().map( UserRole::getName ).toArray( String[]::new );
//            // user 와 listUserRole 을 이용해서 userDetails 객체 생성, return
//            UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
//                    .username(user.getEmail())
//                    .password(user.getPassword())
//                    .roles(rolesStrArray)
//                    .build();
//
//            return userDetails;
//        }
//
//        throw new UsernameNotFoundException("User not found");
//    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<User> optionalUser = userRepository.findByEmail(email);


        if( optionalUser.isPresent() ) {
            User user = optionalUser.get();
            List<UserRole> listUserRole = user.getUserRoles();

            List<SimpleGrantedAuthority> authorities =
                    listUserRole.stream().map(UserRole::getName).map(String::new).map(SimpleGrantedAuthority::new).toList();

            // MyUserDetails 사용
            UserDetails userDetails = MyUserDetails.builder()
                    .username(user.getEmail())
                    .password(user.getPassword())
                    .email(user.getEmail()) // user의 다양한 정보를 추가
                    .authorities(authorities)
                    .build();

            return userDetails;
        }

        throw new UsernameNotFoundException("User not found");
    }
}