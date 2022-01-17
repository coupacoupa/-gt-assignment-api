package com.govtech.assignment;

import com.govtech.assignment.dto.SubmissionFormDto;

public class TestConstants {
    public static final String NAME = "NAME1";
    public static final String EMAIL = "EMAIL1@EMAIL.COM";
    public static final String CONTACT_NUMBER = "CONTACT_NUMBER1";
    public static final String AGENCY_NAME = "AGENCY_NAME1";
    public static final String FEEDBACK = "FEEDBACK1";

    public static final String NAME2 = "NAME2";
    public static final String EMAIL2 = "EMAIL2@EMAIL.COM";
    public static final String CONTACT_NUMBER2 = "CONTACT_NUMBER2";
    public static final String AGENCY_NAME2 = "AGENCY_NAME2";
    public static final String FEEDBACK2 = "FEEDBACK2";

    public static SubmissionFormDto getSubmissionFormDto() {
        return SubmissionFormDto.builder()
                .agencyName(AGENCY_NAME)
                .contactNumber(CONTACT_NUMBER)
                .email(EMAIL)
                .feedback(FEEDBACK)
                .name(NAME)
                .build();
    }

    public static SubmissionFormDto getSubmissionFormDto2() {
        return SubmissionFormDto.builder()
                .agencyName(AGENCY_NAME2)
                .contactNumber(CONTACT_NUMBER2)
                .email(EMAIL2)
                .feedback(FEEDBACK2)
                .name(NAME2)
                .build();
    }

    public static SubmissionFormDto getSubmissionFormDtoWithInvalidEmail() {
        return SubmissionFormDto.builder()
                .agencyName(AGENCY_NAME)
                .contactNumber(CONTACT_NUMBER)
                .email("EMAIL")
                .feedback(FEEDBACK)
                .name(NAME)
                .build();
    }
}