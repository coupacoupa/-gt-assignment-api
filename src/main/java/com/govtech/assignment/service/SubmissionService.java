package com.govtech.assignment.service;

import com.govtech.assignment.entity.Submission;
import com.govtech.assignment.repository.SubmissionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class SubmissionService {
    @Autowired
    private SubmissionRepository submissionRepository;

    @Autowired
    private CodeifyService codeifyService;

    public Submission saveSubmissionForm(Submission submission) {
        log.info("[saveSubmissionForm]");

        // Call codeify api to get feedback status
        codeifyService.getFeedbackDto(submission);

        return submissionRepository.save(submission);
    }

    public List<Submission> getAllSubmissionStatusByEmailAndContactNumber(String email, String contactNumber) {
        log.info("[getAllSubmissionStatus]");

        return submissionRepository.findByEmailAndContactNumber(email, contactNumber);
    }
}
