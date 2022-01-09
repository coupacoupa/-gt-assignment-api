package com.govtech.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserDto {
    @NotEmpty(message = "Email is mandatory")
    private String email;

    @NotEmpty(message = "Contact Number is mandatory")
    private String contactNumber;
}
