package com.laptop.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "admin")
@Getter
@Setter
@Valid
@NoArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotBlank
    private String email;

    @Override
    public String toString() {
        return "Admin{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                '}';
    }
}
