package com.govtech.assignment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.govtech.assignment.GtAssignmentIntegrationTest;
import com.govtech.assignment.TestConstants;
import com.govtech.assignment.dto.SubmissionFormDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@GtAssignmentIntegrationTest
@Sql(value = "/create-data.sql")
@Sql(scripts = "/cleanup.sql", executionPhase = AFTER_TEST_METHOD)
public class SubmissionControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void givenUser1_whenGetSubmissions_thenExpectFilteredUser() throws Exception {
        mvc.perform(get("/api/v1/submissions?email=" + TestConstants.EMAIL + "&contactNumber=" + TestConstants.CONTACT_NUMBER)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.statusCode").value(200))
                .andExpect(jsonPath("$.data.totalCount").value(15))
                .andExpect(jsonPath("$.data.submissions", hasSize(15)))
                .andExpect(jsonPath("$.data.submissions[0].email").value(TestConstants.EMAIL))
                .andExpect(jsonPath("$.data.submissions[0].contactNumber").value(TestConstants.CONTACT_NUMBER));
    }

    @Test
    public void givenUser1WithPageSize5_whenGetSubmissions_thenExpectMax5() throws Exception {
        mvc.perform(get("/api/v1/submissions?email=" + TestConstants.EMAIL + "&contactNumber=" + TestConstants.CONTACT_NUMBER + "&page=0&size=5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.statusCode").value(200))
                .andExpect(jsonPath("$.data.totalCount").value(15))
                .andExpect(jsonPath("$.data.submissions", hasSize(5)))
                .andExpect(jsonPath("$.data.submissions[0].email").value(TestConstants.EMAIL))
                .andExpect(jsonPath("$.data.submissions[0].contactNumber").value(TestConstants.CONTACT_NUMBER));
    }

    @Test
    public void givenUser2_whenGetSubmissions_thenExpectFilteredUser() throws Exception {
        mvc.perform(get("/api/v1/submissions?email=" + TestConstants.EMAIL2 + "&contactNumber=" + TestConstants.CONTACT_NUMBER2)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.statusCode").value(200))
                .andExpect(jsonPath("$.data.totalCount").value(1))
                .andExpect(jsonPath("$.data.submissions[0].email").value(TestConstants.EMAIL2))
                .andExpect(jsonPath("$.data.submissions[0].contactNumber").value(TestConstants.CONTACT_NUMBER2));
    }

    @Test
    public void givenValidSubmission_whenSaveSubmissions_thenExpectSubmissionSaved() throws Exception {
        mvc.perform(post("/api/v1/submissions")
                        .content(asJsonString(TestConstants.getSubmissionFormDto()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.statusCode").value(201))
                .andExpect(jsonPath("$.data.name").value(TestConstants.NAME))
                .andExpect(jsonPath("$.data.email").value(TestConstants.EMAIL))
                .andExpect(jsonPath("$.data.contactNumber").value(TestConstants.CONTACT_NUMBER))
                .andExpect(jsonPath("$.data.agencyName").value(TestConstants.AGENCY_NAME))
                .andExpect(jsonPath("$.data.feedback").value(TestConstants.FEEDBACK));
    }

    @Test
    public void givenEmptySubmission_whenSaveSubmissions_thenExpectValidation() throws Exception {
        SubmissionFormDto submissionFormDto = SubmissionFormDto.builder().build();

        mvc.perform(post("/api/v1/submissions")
                        .content(asJsonString(submissionFormDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.statusCode").value(400))
                .andExpect(jsonPath("$.message.feedback").value("Feedback is mandatory"))
                .andExpect(jsonPath("$.message.contactNumber").value("Contact Number is mandatory"))
                .andExpect(jsonPath("$.message.name").value("Name is mandatory"))
                .andExpect(jsonPath("$.message.email").value("Email is mandatory"));
    }

    @Test
    public void givenInvalidEmail_whenSaveSubmissions_thenExpectValidation() throws Exception {

        mvc.perform(post("/api/v1/submissions")
                        .content(asJsonString(TestConstants.getSubmissionFormDtoWithInvalidEmail()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.statusCode").value(400))
                .andExpect(jsonPath("$.message.email").value("must be a well-formed email address"));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
