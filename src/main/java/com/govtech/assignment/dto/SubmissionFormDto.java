package com.govtech.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class SubmissionFormDto {

    @NotEmpty(message = "Name is mandatory")
    @Size(max = 100, message = "Name exceeded maximum size of 100")
    private String name;

    @NotEmpty(message = "Email is mandatory")
    @Size(max = 100, message = "Email exceeded maximum size of 100")
    @Email
    private String email;

    @NotEmpty(message = "Contact Number is mandatory")
    @Size(max = 26, message = "Contact Number exceeded maximum size of 26")
    private String contactNumber;

    @Size(max = 100, message = "Agency Name exceeded maximum size of 100")
    private String agencyName;

    @NotEmpty(message = "Feedback is mandatory")
    @Size(max = 256, message = "Feedback exceeded maximum size of 256")
    private String feedback;
}
