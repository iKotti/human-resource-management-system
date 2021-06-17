package com.ikotti.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikotti.hrms.business.abstracts.WorkingTimeTypeService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.concretes.WorkingTimeType;

@RestController
@RequestMapping("/api/workingTimeTypes")
@CrossOrigin
public class WorkingTimeTypeController {
	private WorkingTimeTypeService workingTimeTypeService;

	@Autowired
	public WorkingTimeTypeController(WorkingTimeTypeService workingTimeTypeService) {
		this.workingTimeTypeService = workingTimeTypeService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody WorkingTimeType workingTimeType) {
		return workingTimeTypeService.add(workingTimeType);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<WorkingTimeType>> getAll() {
		return workingTimeTypeService.getAll();
	}
	
}
