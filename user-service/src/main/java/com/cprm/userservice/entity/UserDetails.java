package com.cprm.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "First name should not be Null")
    @NotEmpty(message = "First name should not be empty")
    @Size(min = 4,max = 8)
    private String firstName;
    @NotNull(message = "Last name should not be Null")
    @NotEmpty(message = "Last name should not be Empty")
    private String lastName;
    @NotNull(message = "Last name should not be Null")
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be a valid email")
    private String email;
    @Min(value = 18,message = "Age should not be less than 18")
    private String age;
}

