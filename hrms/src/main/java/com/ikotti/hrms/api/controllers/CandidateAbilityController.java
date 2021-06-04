package com.ikotti.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikotti.hrms.business.abstracts.CandidateAbilityService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.concretes.CandidateAbility;

@RestController
@RequestMapping("/api/candidateabilities")
public class CandidateAbilityController {

	private CandidateAbilityService candidateAbilityService;

	@Autowired
	public CandidateAbilityController(CandidateAbilityService candidateAbilityService) {
		super();
		this.candidateAbilityService = candidateAbilityService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CandidateAbility candidateAbility, int candidateId) {
		return candidateAbilityService.add(candidateAbility,candidateId);
	}

	@PostMapping("/addAll")
	public Result addAll(@RequestBody List<CandidateAbility> candidateAbility, int candidateId) {
		return candidateAbilityService.addAll(candidateAbility,candidateId);
	}

	@GetMapping("/getAll")
	public DataResult<List<CandidateAbility>> getAll() {
		return candidateAbilityService.getAll();
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<CandidateAbility>> getAllByCandidateId(int candidateId) {
		return candidateAbilityService.getAllByCandidateId(candidateId);
	}
}