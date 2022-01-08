package com.govtech.assignment.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Submission {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long rowuid;

    private String name;

    private String email;

    private String contactNumber;

    private String agencyName;

    private String feedback;

    private String feedbackStatus;
}
