package com.ikotti.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikotti.hrms.business.abstracts.JobPositionService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.ErrorResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.core.utilities.results.SuccessDataResult;
import com.ikotti.hrms.core.utilities.results.SuccessResult;
import com.ikotti.hrms.dataAccess.abstracts.JobPositionDao;
import com.ikotti.hrms.entity.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
	
	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll());
	}

	@Override
	public Result add(JobPosition jobPosition) {
		
		if(getByTitle(jobPosition.getTitle()).getData() != null) {
			return new ErrorResult("Bu iş adı zaten kayıtlı.");
		}
		
		jobPositionDao.save(jobPosition);
		return new SuccessResult("İş adı başarıyla kaydedildi.");
		
	}

	@Override
	public DataResult<JobPosition> getByTitle(String title) {
		return new SuccessDataResult<JobPosition>(jobPositionDao.getByTitle(title));
	}
	
	
	
	

}
