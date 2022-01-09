package com.govtech.assignment.repository;

import com.govtech.assignment.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
    List<Submission> findByEmailAndContactNumber(String email, String contactNumber);

    Submission save(Submission submission);
}
