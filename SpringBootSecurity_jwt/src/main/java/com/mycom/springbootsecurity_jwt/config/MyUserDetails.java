package com.mycom.springbootsecurity_jwt.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@AllArgsConstructor
@Builder
public class MyUserDetails implements UserDetails {
    private static final long serialVersionUID = 1L;

    private final String username;
    private final String password;
    private final String email; // extra field
    private final Collection<? extends GrantedAuthority> authorities;

    public String getEmail() {
        return email;
    }

    @Override public String getUsername() { return username; }
    @Override public String getPassword() { return password; }
    @Override public Collection<? extends GrantedAuthority> getAuthorities() { return authorities; }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }
}