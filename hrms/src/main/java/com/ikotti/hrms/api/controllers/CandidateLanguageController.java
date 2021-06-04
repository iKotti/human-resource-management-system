package com.ikotti.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikotti.hrms.business.abstracts.CandidateLanguageService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.concretes.CandidateLanguage;

@RestController
@RequestMapping("/api/CandidateLanguages")
public class CandidateLanguageController {

	private CandidateLanguageService candidateLanguageService;

	@Autowired
	public CandidateLanguageController(CandidateLanguageService candidateLanguageService) {
		super();
		this.candidateLanguageService = candidateLanguageService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CandidateLanguage candidateLanguage,int candidateId) {
		return candidateLanguageService.add(candidateLanguage,candidateId);
	}
	
	@PostMapping("*addAll")
	public Result addAll(List<CandidateLanguage> candidateLanguages,int candidateId) {
		return candidateLanguageService.addAll(candidateLanguages,candidateId);
	}

	@GetMapping("/getAll")
	public DataResult<List<CandidateLanguage>> getAll() {
		return candidateLanguageService.getAll();
	}

}
