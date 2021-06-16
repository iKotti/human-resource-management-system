package com.ikotti.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ikotti.hrms.business.abstracts.CurriculumVitaeService;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.dtos.CurriculumVitaeDto;

@RestController
@RequestMapping("/api/curriculumVitaes")
@CrossOrigin
public class CurriculumVitaeController {
	
	private CurriculumVitaeService curriculumVitaeService;

	@Autowired
	public CurriculumVitaeController(CurriculumVitaeService curriculumVitaeService) {
		this.curriculumVitaeService = curriculumVitaeService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CurriculumVitaeDto curriculumVitaeDto, int candidateId) {
		return curriculumVitaeService.add(curriculumVitaeDto, candidateId);
	}
}
