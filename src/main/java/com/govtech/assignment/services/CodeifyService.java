package com.govtech.assignment.services;

import com.govtech.assignment.common.utils.StringUtil;
import com.govtech.assignment.dtos.FeedbackDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
public class CodeifyService {

    @Value("${codeify.submit-feedback.url}")
    private String codeifySubmitFeedbackUrl;

    public String getFeedbackDto (String feedback) {
        RestTemplate restTemplate = new RestTemplate();
        String sanitizedFeedback = StringUtil.sanitizeUserInput(feedback);

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(codeifySubmitFeedbackUrl)
                .queryParam("feedback", sanitizedFeedback);

        ResponseEntity<FeedbackDto> response = restTemplate.getForEntity(builder.toUriString(), FeedbackDto.class);

        return response.getBody().getStatus();
    }
}
