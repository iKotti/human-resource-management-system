package com.ikotti.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikotti.hrms.business.abstracts.WorkingPlaceTypeService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.concretes.WorkingPlaceType;

@RestController
@RequestMapping("/api/workingPlaceTypes")
@CrossOrigin
public class WorkingPlaceTypeController {

	private WorkingPlaceTypeService workingPlaceTypeService;

	@Autowired
	public WorkingPlaceTypeController(WorkingPlaceTypeService workingPlaceTypeService) {
		this.workingPlaceTypeService = workingPlaceTypeService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody WorkingPlaceType workingPlaceType) {
		return workingPlaceTypeService.add(workingPlaceType);
	}

	@GetMapping("/getAll")
	public DataResult<List<WorkingPlaceType>> getAll() {
		return workingPlaceTypeService.getAll();
	}

}
