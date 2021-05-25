package com.ikotti.hrms.business.abstracts;

import java.util.List;

import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.concretes.JobPosition;


public interface JobPositionService {
	List<JobPosition> getAll();
	Result add(JobPosition jobPosition);
}
