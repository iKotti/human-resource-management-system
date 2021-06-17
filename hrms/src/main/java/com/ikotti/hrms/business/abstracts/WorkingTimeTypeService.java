package com.ikotti.hrms.business.abstracts;

import java.util.List;

import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.concretes.WorkingTimeType;

public interface WorkingTimeTypeService {
	Result add(WorkingTimeType workingTimeType);

	DataResult<List<WorkingTimeType>> getAll();
}
