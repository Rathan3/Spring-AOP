package com.learnspring.Springboot_Rest.service;

import com.learnspring.Springboot_Rest.model.JobPost;
import com.learnspring.Springboot_Rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepo repo;

    public void addJob( JobPost jobPost){
        repo.save(jobPost);
    }

    public List<JobPost> getAllJobs(){
        return repo.findAll();
    }

    public JobPost getJob(int jobId) {
        return repo.findById(jobId).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost){
       repo.save(jobPost);
    }

    public void deleteJob(int jobId){

        repo.deleteById(jobId);
    }

    public void loadJobs(List<JobPost> jobs){
        repo.saveAll(jobs);
    }

}
