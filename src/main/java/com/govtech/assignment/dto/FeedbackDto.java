package com.govtech.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class FeedbackDto {
    private String sentiment;

    private int time;

    private String feedback;

    private String status;
}
