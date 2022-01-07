package com.govtech.assignment.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class SubmissionStatusDto extends SubmissionFormDto {
    private String feedbackStatus;
}
