package com.govtech.assignment.repositories;

import com.govtech.assignment.entities.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
    List<Submission> findByEmailAndContactNumber(String email, String contactNumber);

    Submission save(Submission submission);
}
