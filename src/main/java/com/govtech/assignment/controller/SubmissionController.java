package com.govtech.assignment.controller;

import com.govtech.assignment.dto.ResponseDto;
import com.govtech.assignment.dto.SubmissionFilterDto;
import com.govtech.assignment.dto.SubmissionFormDto;
import com.govtech.assignment.entity.Submission;
import com.govtech.assignment.mapper.SubmissionMapper;
import com.govtech.assignment.service.SubmissionService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/submissions")
@Validated
@CrossOrigin
public class SubmissionController {
    @Autowired
    private SubmissionService submissionService;

    private SubmissionMapper submissionMapper = Mappers.getMapper(SubmissionMapper.class);

    @PostMapping()
    public ResponseEntity<ResponseDto> saveSubmissionForm (@RequestBody @Valid SubmissionFormDto submissionFormDto) throws ExecutionException, InterruptedException {
        Submission submission = submissionMapper.submissionFormDtoToSubmission(submissionFormDto);

        ResponseDto responseDto = new ResponseDto(
                submissionMapper.submissionToSubmissionStatusDto(submissionService.saveSubmissionForm(submission)),
                HttpStatus.CREATED.value()
        );

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<ResponseDto> getAllSubmissionStatus (@RequestParam String email, @RequestParam  String contactNumber) {
        ResponseDto responseDto = new ResponseDto(
                submissionMapper.submissionsToSubmissionStatusDtos(
                        submissionService.getAllSubmissionStatusByEmailAndContactNumber(email, contactNumber)
                ),
                HttpStatus.OK.value()
        );

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
