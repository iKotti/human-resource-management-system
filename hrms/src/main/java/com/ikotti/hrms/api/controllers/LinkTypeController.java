package com.ikotti.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikotti.hrms.business.abstracts.LinkTypeService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.entity.concretes.LinkType;

@RestController
@RequestMapping("api/linktypes")
public class LinkTypeController {

	private LinkTypeService linkTypeService;

	@Autowired
	public LinkTypeController(LinkTypeService linkTypeService) {
		this.linkTypeService = linkTypeService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody LinkType linkType) {
		return ResponseEntity.ok(linkTypeService.add(linkType));
	}

	@GetMapping("/getall")
	public DataResult<List<LinkType>> getAll() {
		return linkTypeService.getAll();
	}

}
