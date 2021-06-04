package com.ikotti.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikotti.hrms.business.abstracts.CandidatePictureService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.concretes.CandidatePicture;

@RestController
@RequestMapping("/api/candidatePictures")
public class CandidatePictureController {

	private CandidatePictureService candidatePictureService;

	@Autowired
	public CandidatePictureController(CandidatePictureService candidatePictureService) {
		this.candidatePictureService = candidatePictureService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CandidatePicture candidatePicture,int candidateId) {
		return candidatePictureService.add(candidatePicture,candidateId);
	}

	@PostMapping("/getAll")
	public DataResult<List<CandidatePicture>> getAll() {
		return candidatePictureService.getAll();
	}

}
