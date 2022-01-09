package com.govtech.assignment.service;

import com.govtech.assignment.common.utils.StringUtil;
import com.govtech.assignment.dto.FeedbackDto;
import com.govtech.assignment.entity.Submission;
import com.govtech.assignment.repository.SubmissionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
public class CodeifyService {

    @Autowired
    private SubmissionRepository submissionRepository;

    @Value("${codeify.submit-feedback.url}")
    private String codeifySubmitFeedbackUrl;

    @Async("threadPoolTaskExecutor")
    public void getFeedbackDto (Submission submission) {
        log.info("[getFeedbackDto] Retrieving feedback status");

        RestTemplate restTemplate = new RestTemplate();
        String sanitizedFeedback = StringUtil.sanitizeUserInput(submission.getFeedback());

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(codeifySubmitFeedbackUrl)
                .queryParam("feedback", sanitizedFeedback);

        ResponseEntity<FeedbackDto> response = restTemplate.getForEntity(builder.toUriString(), FeedbackDto.class);
        String feedbackStatus = response.getBody().getStatus();
        submission.setFeedbackStatus(feedbackStatus);
        submissionRepository.save(submission);
        log.info("[getFeedbackDto] Updated submission with feedbackStatus: " + feedbackStatus);
    }
}
