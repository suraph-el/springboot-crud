package com.cogni.springaws.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.StringJoiner;
@Entity
@Data
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

//    @NotEmpty(message = "Name can not be null or empty")
//    @Size(min=6,max=10, message="the length of first name should be between 5 and 10")
    private String firstName;
//    @NotEmpty(message = "Name can not be null or empty")
//    @Size(min=5,max=8, message="the length of first name should be between 5 and 10")

    private String lastName;
//    @NotEmpty(message = "please put your email")
//    @Email(message = "email address should be valid value")
    private String email;

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("email='" + email + "'")
                .toString();
    }
}
