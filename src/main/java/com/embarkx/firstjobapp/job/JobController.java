package com.embarkx.firstjobapp.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/jobs")
    public List<Job> findAll() {
        return jobService.findAll();
    }

    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return "Job added successfully";
    }

    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable Long id) {
        Job job = jobService.getJobById(id);
        if (job != null)
            return job;
        return new Job(1L, "TestJob", "TestJob", "2000", "2000", "Loc");

    }
}
