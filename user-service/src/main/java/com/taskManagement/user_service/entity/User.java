package com.taskManagement.user_service.entity;


import com.taskManagement.user_service.enums.Role;
import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Role role = Role.USER;

    private String firstName;
    private String lastName;

    @Builder.Default
    private String country = "India";

    @PrePersist
    public void setDefaults() {
        if (role == null) {
            role = Role.USER;
        }

        if (country == null) {
            country = "India";
        }
    }
}
