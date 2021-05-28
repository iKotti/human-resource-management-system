package com.ikotti.hrms.business.abstracts;

import java.util.List;

import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.concretes.JobPosting;

public interface JobPostingService {
	DataResult<List<JobPosting>> getAll();

	Result add(JobPosting jobPosting);
	
	DataResult<List<JobPosting>> getSortedByCreationDate();
	
	DataResult<List<JobPosting>> getByCompanyName(String companyName);

}
