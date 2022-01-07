package com.govtech.assignment.services;

import com.govtech.assignment.dtos.SubmissionFormDto;
import com.govtech.assignment.dtos.UserSubmissionStatusDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SubmissionService {

    public void saveSubmissionForm(SubmissionFormDto submissionFormDto) {
        log.info("[saveSubmissionForm]");
    }

    public void getAllSubmissionStatus(UserSubmissionStatusDto userSubmissionStatusDto) {
        log.info("[getAllSubmissionStatus]");
    }
}
