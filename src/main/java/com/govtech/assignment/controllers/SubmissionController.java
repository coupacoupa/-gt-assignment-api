package com.govtech.assignment.controllers;

import com.govtech.assignment.dtos.ResponseDto;
import com.govtech.assignment.dtos.SubmissionFormDto;
import com.govtech.assignment.dtos.UserSubmissionStatusDto;
import com.govtech.assignment.services.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/submissions")
@Validated
public class SubmissionController {
    @Autowired
    private SubmissionService submissionService;

    @PostMapping()
    public ResponseEntity<ResponseDto> saveSubmissionForm (@RequestBody @Valid SubmissionFormDto submissionFormDto) {
        submissionService.saveSubmissionForm(submissionFormDto);
        return new ResponseEntity<>(new ResponseDto("test", HttpStatus.CREATED.value()), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<ResponseDto> getAllSubmissionStatus (@RequestBody @Valid UserSubmissionStatusDto userSubmissionStatusDto) {
        submissionService.getAllSubmissionStatus(userSubmissionStatusDto);
        return new ResponseEntity<>(new ResponseDto("test", HttpStatus.OK.value()), HttpStatus.OK);
    }
}
