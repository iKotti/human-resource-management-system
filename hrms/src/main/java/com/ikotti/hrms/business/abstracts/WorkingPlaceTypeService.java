package com.ikotti.hrms.business.abstracts;

import java.util.List;

import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.concretes.WorkingPlaceType;

public interface WorkingPlaceTypeService {
	Result add(WorkingPlaceType workingPlaceType);

	DataResult<List<WorkingPlaceType>> getAll();
}
