package com.govtech.assignment.services;

import com.govtech.assignment.dtos.FeedbackDto;
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

    @Autowired
    private CodeifyService codeifyService;

    public Submission saveSubmissionForm(Submission submission) {
        log.info("[saveSubmissionForm]");

        // Call codeify api to get feedback status
        String feedbackStatus = codeifyService.getFeedbackDto(submission.getFeedback());
        submission.setFeedbackStatus(feedbackStatus);

        return submissionRepository.save(submission);
    }

    public List<Submission> getAllSubmissionStatusByEmailAndContactNumber(String email, String contactNumber) {
        log.info("[getAllSubmissionStatus]");

        return submissionRepository.findByEmailAndContactNumber(email, contactNumber);
    }
}
