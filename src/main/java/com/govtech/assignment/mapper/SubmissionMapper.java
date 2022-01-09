package com.govtech.assignment.mapper;

import com.govtech.assignment.dto.SubmissionFormDto;
import com.govtech.assignment.dto.SubmissionStatusDto;
import com.govtech.assignment.entity.Submission;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface SubmissionMapper {
    Submission submissionFormDtoToSubmission (SubmissionFormDto submissionFormDto);

    SubmissionStatusDto submissionToSubmissionStatusDto (Submission submission);

    List<SubmissionStatusDto> submissionsToSubmissionStatusDtos (List<Submission> submissions);
}
