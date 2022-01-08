package com.govtech.assignment.mappers;

import com.govtech.assignment.dtos.SubmissionFormDto;
import com.govtech.assignment.dtos.SubmissionStatusDto;
import com.govtech.assignment.entities.Submission;
import org.mapstruct.Mapper;

@Mapper
public interface SubmissionMapper {
    Submission submissionFormDtoToSubmission (SubmissionFormDto submissionFormDto);
    SubmissionFormDto submissionToSubmissionFormDto (Submission submission);

    Submission submissionStatusDtoToSubmission (SubmissionStatusDto submissionStatusDto);
    SubmissionStatusDto submissionToSubmissionStatusDto (Submission submission);
}
