package com.ikotti.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ikotti.hrms.business.abstracts.WorkingPlaceTypeService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.core.utilities.results.SuccessDataResult;
import com.ikotti.hrms.core.utilities.results.SuccessResult;
import com.ikotti.hrms.dataAccess.abstracts.WorkingPlaceTypeDao;
import com.ikotti.hrms.entity.concretes.WorkingPlaceType;

@Service
public class WorkingPlaceTypeManager implements WorkingPlaceTypeService {

	private WorkingPlaceTypeDao workingPlaceTypeDao;

	public WorkingPlaceTypeManager(WorkingPlaceTypeDao workingPlaceTypeDao) {
		this.workingPlaceTypeDao = workingPlaceTypeDao;
	}

	@Override
	public Result add(WorkingPlaceType workingPlaceType) {
		workingPlaceTypeDao.save(workingPlaceType);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<WorkingPlaceType>> getAll() {
		return new SuccessDataResult<List<WorkingPlaceType>>(workingPlaceTypeDao.findAll());
	}

}
