package com.ikotti.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikotti.hrms.business.abstracts.WorkingTimeTypeService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.core.utilities.results.SuccessDataResult;
import com.ikotti.hrms.core.utilities.results.SuccessResult;
import com.ikotti.hrms.dataAccess.abstracts.WorkingTimeTypeDao;
import com.ikotti.hrms.entity.concretes.WorkingTimeType;

@Service
public class WorkingTimeTypeManager implements WorkingTimeTypeService {
	
	private WorkingTimeTypeDao workingTimeTypeDao;

	@Autowired
	public WorkingTimeTypeManager(WorkingTimeTypeDao workingTimeTypeDao) {
		this.workingTimeTypeDao = workingTimeTypeDao;
	}

	@Override
	public Result add(WorkingTimeType workingTimeType) {
		workingTimeTypeDao.save(workingTimeType);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<WorkingTimeType>> getAll() {
		return new SuccessDataResult<List<WorkingTimeType>>(workingTimeTypeDao.findAll());
	}
	
	
	
	
}
