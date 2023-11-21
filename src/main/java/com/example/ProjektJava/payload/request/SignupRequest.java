package com.example.ProjektJava.payload.request;

import com.example.ProjektJava.validation.StrongPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
public class SignupRequest {
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 20, message = "Username must have between 3 and 20 characters")
    private String username;

    @NotBlank(message = "Email is required")
    @Size(max = 50, message = "Email cannot be longer than 50 characters")
    @Email(message = "Invalid email format")
    private String email;

    private Set<String> role;

    @NotBlank(message = "Password is required")
    @StrongPassword
    private String password;
}
