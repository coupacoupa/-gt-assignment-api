package com.govtech.assignment.services;

import com.govtech.assignment.dtos.UserSubmissionStatusDto;
import com.govtech.assignment.entities.Submission;
import com.govtech.assignment.repositories.SubmissionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SubmissionService {
    @Autowired
    private SubmissionRepository submissionRepository;

    public Submission saveSubmissionForm(Submission submission) {
        log.info("[saveSubmissionForm]");

        return submissionRepository.save(submission);
    }

    public List<Submission> getAllSubmissionStatusByEmailAndContactNumber(String email, String contactNumber) {
        log.info("[getAllSubmissionStatus]");

        return submissionRepository.findByEmailAndContactNumber(email, contactNumber);
    }
}
