package com.laptop.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdatePasswordRequest {
        @Size(min = 8, max = 30, message = "Password length must be between 8 and 30 characters")
        @Pattern(regexp = ".*[0-9].*", message = "Password must contain at least one digit (0-9).")
        @Pattern(regexp = ".*[a-z].*", message = "Password must contain at least one lowercase letter (a-z).")
        @Pattern(regexp = ".*[A-Z].*", message = "Password must contain at least one uppercase letter (A-Z).")
        private String password;
}
