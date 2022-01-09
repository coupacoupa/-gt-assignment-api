package com.govtech.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class SubmissionStatusDto extends SubmissionFormDto {
    private Long submissionNo;

    private String feedbackStatus;

    private LocalDateTime createdDate;
}
