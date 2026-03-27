package com.jobtracker.job;

import com.jobtracker.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "jobs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @CreationTimestamp
    @Column(name = "applied_date", nullable = false)
    private LocalDateTime appliedAt;

    @Column(name = "job_url", nullable = false, length = 1024)
    private String jobURL;

    @Column(name = "job_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private JobStatus jobStatus = JobStatus.APPLIED;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @UpdateTimestamp
    @Column(name = "last_updated", nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

}
