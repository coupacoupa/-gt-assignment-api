package com.govtech.assignment.controller;

import com.govtech.assignment.dto.*;
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
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

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

        // To see isLoading in frontend
//        TimeUnit.SECONDS.sleep(1);

        ResponseDto responseDto = new ResponseDto(
                submissionMapper.submissionToSubmissionStatusDto(submissionService.saveSubmissionForm(submission)),
                HttpStatus.CREATED.value()
        );

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<ResponseDto> getAllSubmissionStatus (@RequestParam String email, @RequestParam  String contactNumber, @RequestParam(defaultValue = "0") int page,  @RequestParam(defaultValue = "20")  int size) {
        List<SubmissionStatusDto> submissionStatusDtos = submissionMapper.submissionsToSubmissionStatusDtos(
                submissionService.getAllSubmissionStatusByEmailAndContactNumber(email, contactNumber, page, size)
        );

        Long submissionCount = submissionService.getSubmissionCountByEmailAndContactNumber(email, contactNumber);

        ResponseDto responseDto = new ResponseDto(
                SubmissionResponseDto.builder().submissions(submissionStatusDtos).totalCount(submissionCount).build(),
                HttpStatus.OK.value()
        );

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
