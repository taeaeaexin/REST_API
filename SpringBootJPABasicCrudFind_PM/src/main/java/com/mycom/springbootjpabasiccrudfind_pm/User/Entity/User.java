package com.mycom.springbootjpabasiccrudfind_pm.User.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
}
