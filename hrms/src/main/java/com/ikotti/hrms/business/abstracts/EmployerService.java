package com.ikotti.hrms.business.abstracts;

import java.util.List;

import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.concretes.Employer;

public interface EmployerService {
	DataResult<List<Employer>> getAll();
	Result add(Employer employer);
	Result update(Employer employer);
}
