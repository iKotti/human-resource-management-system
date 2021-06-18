package com.ikotti.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ikotti.hrms.business.abstracts.JobPostingService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.concretes.JobPosting;
import com.ikotti.hrms.entity.dtos.JobPostingListDto;

@RestController
@RequestMapping("/api/jobpostings")
@CrossOrigin
public class JobPostingController {
	
	private JobPostingService jobPostingService;
	
	public JobPostingController(JobPostingService jobPostingService) {
		this.jobPostingService = jobPostingService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosting>> getAll() {
		return jobPostingService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPosting jobPosting) {
		return jobPostingService.add(jobPosting);
	}
	
	@PostMapping("/getSortedByCreationDate")
	public DataResult<List<JobPosting>> getSortedByCreationDate() {
		return jobPostingService.getSortedByCreationDate();
	}
	
	@PostMapping("/getByCompanyName")
	public DataResult<List<JobPosting>> getByCompanyName(@RequestParam String companyName) {
		return jobPostingService.getByCompanyName(companyName);
	}
	
	@PostMapping("/updateJobPostingActivation")
	public Result updateJobPostingActivation(@RequestParam int id, Boolean activationStatus) {
		return jobPostingService.updateJobPostingActivation(id, activationStatus);
	}
	
	@GetMapping("/getJobPostingList")
	public DataResult<List<JobPostingListDto>> getJobPostingList() {
		return jobPostingService.getJobPostingList();
	}
	
	@GetMapping("/getById")
	public DataResult<JobPosting> getById(@RequestParam int id) {
		return jobPostingService.getById(id);
	}
	
	@GetMapping("/getByIsConfirmed")
	public DataResult<List<JobPosting>> getByIsConfirm(@RequestParam Boolean isConfirm) {
		return jobPostingService.getByIsConfirm(isConfirm);
	}
}
