package com.govtech.assignment.service;

import com.govtech.assignment.entity.Submission;
import com.govtech.assignment.repository.SubmissionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        submission.setFeedbackStatus("Processing");

        // Call codeify api to get feedback status
        codeifyService.getFeedbackDto(submission);

        return submissionRepository.save(submission);
    }

    public List<Submission> getAllSubmissionStatusByEmailAndContactNumber(String email, String contactNumber, int page, int size) {
        log.info("[getAllSubmissionStatus]");

        Pageable pageable = PageRequest.of(page, size, Sort.by("createdDate").descending());
        return submissionRepository.findByEmailAndContactNumber(email, contactNumber, pageable);
    }
}
