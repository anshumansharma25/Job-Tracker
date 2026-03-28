package com.jobtracker.job.repository;

import com.jobtracker.job.entity.Job;
import com.jobtracker.job.entity.JobStatus;
import com.jobtracker.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByCompanyName(String companyName);
    List<Job> findByJobStatus(JobStatus jobStatus);
    Page<Job> findByUser(User user, Pageable pageable);
    List<Job> findByUserAndJobTitleContainingIgnoreCase(User user, String jobTitle);
    List<Job> findByUserAndJobStatusAndCompanyNameContainingIgnoreCase(User user, JobStatus jobStatus, String companyName);
    List<Job> findByUserAndCompanyNameStartingWithIgnoreCase(User user, String companyName);
    Page<Job> findByUserAndJobStatus(User user, JobStatus status, Pageable pageable);
}
