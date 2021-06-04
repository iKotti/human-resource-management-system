package com.ikotti.hrms.business.abstracts;

import java.util.List;

import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.concretes.JobPosting;
import com.ikotti.hrms.entity.dtos.JobPostingListDto;

public interface JobPostingService {
	DataResult<List<JobPostingListDto>> getAll();

	Result add(JobPosting jobPosting);
	
	DataResult<List<JobPosting>> getSortedByCreationDate();
	
	DataResult<List<JobPosting>> getByCompanyName(String companyName);
	
	Result updateJobPostingActivation(int id, Boolean isActive);
	
	DataResult<List<JobPostingListDto>> getJobPostingList();
	

}
