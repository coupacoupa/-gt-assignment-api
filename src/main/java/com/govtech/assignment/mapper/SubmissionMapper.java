package com.govtech.assignment.mapper;

import com.govtech.assignment.dto.SubmissionFormDto;
import com.govtech.assignment.dto.SubmissionStatusDto;
import com.govtech.assignment.entity.Submission;
import org.mapstruct.Mapper;

@Mapper
public interface SubmissionMapper {
    Submission submissionFormDtoToSubmission (SubmissionFormDto submissionFormDto);

    Submission submissionStatusDtoToSubmission (SubmissionStatusDto submissionStatusDto);
    SubmissionStatusDto submissionToSubmissionStatusDto (Submission submission);
}
