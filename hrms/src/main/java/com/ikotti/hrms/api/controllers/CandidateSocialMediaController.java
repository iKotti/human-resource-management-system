package com.ikotti.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikotti.hrms.business.abstracts.CandidateSocialMediaService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.concretes.CandidateSocialMedia;

@RestController
@RequestMapping("/api/candidateSocialMediaController")
@CrossOrigin
public class CandidateSocialMediaController {

	private CandidateSocialMediaService candidateSocialMediaService;

	@Autowired
	public CandidateSocialMediaController(CandidateSocialMediaService candidateSocialMediaService) {
		this.candidateSocialMediaService = candidateSocialMediaService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CandidateSocialMedia candidateSocialMedia,int candidateId) {
		return candidateSocialMediaService.add(candidateSocialMedia,candidateId);
	}
	
	@PostMapping("/addAll")
	public Result addAll(List<CandidateSocialMedia> candidateSocialMedias,int candidateId) {
		return candidateSocialMediaService.addAll(candidateSocialMedias, candidateId);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateSocialMedia>> getAll() {
		return candidateSocialMediaService.getAll();
	}

}
