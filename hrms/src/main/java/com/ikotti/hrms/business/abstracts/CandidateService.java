package com.ikotti.hrms.business.abstracts;

import java.util.List;

import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.concretes.Candidate;

public interface CandidateService {
	DataResult<List<Candidate>> getAll();

	Result add(Candidate candidate);
}