package com.govtech.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class SubmissionFormDto {
    @NotEmpty(message = "Name is mandatory")
    private String name;

    @NotEmpty(message = "Email is mandatory")
    private String email;

    @NotEmpty(message = "Contact Number is mandatory")
    private String contactNumber;

    private String agencyName;

    @NotEmpty(message = "Feedback is mandatory")
    @Size(max = 256)
    private String feedback;
}
