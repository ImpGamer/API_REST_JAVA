package com.api.crud.models;

import com.api.crud.services.UserService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "USERS")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30)
    private String firstName;
    @Column
    private String lastName;
    @Column(length = 50)
    @NotEmpty
    private String email;
    public User(String firstName,String lastName,String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
