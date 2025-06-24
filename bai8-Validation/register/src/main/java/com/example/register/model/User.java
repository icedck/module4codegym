package com.example.register.model;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @NotEmpty
    @Size(min = 5, max = 45)
    String firstName;

    @NotEmpty
    @Size(min = 5, max = 45)
    String lastName;

    @Pattern(regexp = "^0\\d{9}$")
    String phoneNumber;

    @Min(18)
    int age;

    @Email
    String email;
}
