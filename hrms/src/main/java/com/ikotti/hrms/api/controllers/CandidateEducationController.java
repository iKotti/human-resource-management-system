package com.ikotti.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikotti.hrms.business.abstracts.CandidateEducationService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.concretes.CandidateEducation;

@RestController
@RequestMapping("/api/candidateEducations")
@CrossOrigin
public class CandidateEducationController {

	private CandidateEducationService candidateEducationService;

	@Autowired
	public CandidateEducationController(CandidateEducationService candidateEducationService) {
		this.candidateEducationService = candidateEducationService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CandidateEducation candidateEducation, int candidateId) {
		return candidateEducationService.add(candidateEducation, candidateId);
	}

	@PostMapping("/addAll")
	public Result addAll(@RequestBody List<CandidateEducation> candidateEducations, int candidateId) {
		return candidateEducationService.addAll(candidateEducations, candidateId);
	}

	@GetMapping("/getAll")
	public DataResult<List<CandidateEducation>> getAll() {
		return candidateEducationService.getAll();
	}

	@GetMapping("/getAllByCandidateIdOrderByFinishYear")
	public DataResult<List<CandidateEducation>> getAllOrderByFinishYearAsc() {
		return candidateEducationService.getAllOrderByFinishYearAsc();
	}

}
