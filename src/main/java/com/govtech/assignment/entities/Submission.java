package com.govtech.assignment.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
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
