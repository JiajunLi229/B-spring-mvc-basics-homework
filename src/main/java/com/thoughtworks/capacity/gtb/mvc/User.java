package com.thoughtworks.capacity.gtb.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;

    @NotNull(message = "email must not be null")
    @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;

    @NotNull(message = "username must not be null")
    @Size(min = 3, max = 10)
    @Pattern(regexp = "^[0-9a-zA-Z_]{1,}$")
    private String username;

    @NotNull(message = "password must not be null")
    @Size(min = 5, max = 12)
    private String password;
}
