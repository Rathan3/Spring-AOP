package com.learnspring.Springboot_Rest;

import com.learnspring.Springboot_Rest.model.JobPost;
import com.learnspring.Springboot_Rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class JobRestController {
    @Autowired
    private JobService service;

    @GetMapping(path="jobPosts", produces = "application/xml")
    public List<JobPost> getAllJobs(){

        return service.getAllJobs();
    }
    @GetMapping("job/{jobId}")
    public JobPost getJob(@PathVariable("jobId") int jobId){

        return service.getJob(jobId);
    }
    @PostMapping("job")
    public JobPost addJob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }
    @PutMapping("job")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("job/{jobId}")
    public String deleteJob(@PathVariable("jobId") int jobId){
        service.deleteJob(jobId);
        return "deleted";
    }

    @GetMapping("load")
    public void loadJobs(){
        List<JobPost> jobs= new ArrayList<>(Arrays.asList(
                new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                        List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
                new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
                        3, List.of("HTML", "CSS", "JavaScript", "React")),
                new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                        List.of("Python", "Machine Learning", "Data Analysis")),
                new JobPost(4, "Network Engineer",
                        "Design and implement computer networks for efficient data communication", 5,
                        List.of("Networking", "Cisco", "Routing", "Switching")),
                new JobPost(6, "DevOps Engineer", "Implement and manage continuous integration and delivery pipelines",
                        4, List.of("DevOps", "CI/CD", "Docker", "Kubernetes")),
                new JobPost(7, "UI/UX Designer", "Create engaging user experiences and intuitive user interfaces",
                        2, List.of("User Experience", "User Interface Design", "Prototyping"))

        ));
        service.loadJobs(jobs);
    }
}
