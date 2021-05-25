package com.ikotti.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikotti.hrms.business.abstracts.JobPositionControl;
import com.ikotti.hrms.business.abstracts.JobPositionService;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.core.utilities.results.SuccessResult;
import com.ikotti.hrms.dataAccess.abstracts.JobPositionDao;
import com.ikotti.hrms.entity.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
	
	private JobPositionDao jobPositionDao;
	private JobPositionControl jobPositionControl;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao,JobPositionControl jobPositionControl) {
		this.jobPositionDao = jobPositionDao;
		this.jobPositionControl = jobPositionControl;
	}

	@Override
	public List<JobPosition> getAll() {
		return jobPositionDao.findAll();
	}

	@Override
	public Result add(JobPosition jobPosition) {
		Result checkRegisteredTitle = jobPositionControl.checkRegisteredTitle(jobPosition.getTitle());
		
		if(!checkRegisteredTitle.isSuccess()) {
			return checkRegisteredTitle;
		}
		
		jobPositionDao.save(jobPosition);
		return new SuccessResult("İş adı başarıyla kaydedildi.");
		
	}

}
