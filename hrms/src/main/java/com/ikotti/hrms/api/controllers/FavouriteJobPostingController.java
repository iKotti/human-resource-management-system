package com.ikotti.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ikotti.hrms.business.abstracts.FavouriteJobPostingService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.concretes.FavouriteJobPosting;

@RestController
@RequestMapping("/api/favouriteJobPostings")
@CrossOrigin
public class FavouriteJobPostingController {
	
	private FavouriteJobPostingService favouriteJobPostingService;

	@Autowired
	public FavouriteJobPostingController(FavouriteJobPostingService favouriteJobPostingService) {
		this.favouriteJobPostingService = favouriteJobPostingService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestParam int candidateId, @RequestParam int jobPostingId) { 
		return favouriteJobPostingService.add(candidateId, jobPostingId);
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<FavouriteJobPosting>> getAllByCandidateId(@RequestParam int candidateId) {
		return favouriteJobPostingService.getAllByCandidateId(candidateId);
	}
	
}
