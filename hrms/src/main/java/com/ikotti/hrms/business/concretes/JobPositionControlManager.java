package com.ikotti.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikotti.hrms.business.abstracts.JobPositionControl;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.ErrorResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.core.utilities.results.SuccessDataResult;
import com.ikotti.hrms.core.utilities.results.SuccessResult;
import com.ikotti.hrms.dataAccess.abstracts.JobPositionDao;
import com.ikotti.hrms.entity.concretes.JobPosition;

@Service
public class JobPositionControlManager implements JobPositionControl {

	JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionControlManager(JobPositionDao jobPositionDao) {
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public Result checkRegisteredTitle(String title) {
		if (getByTitle(title).getData() != null) {
			return new ErrorResult("Bu iş adı zaten kayıtlı.");
		}
		return new SuccessResult();
	}

	public DataResult<JobPosition> getByTitle(String title) {
		return new SuccessDataResult<JobPosition>(jobPositionDao.findByTitle(title));
	}

}
