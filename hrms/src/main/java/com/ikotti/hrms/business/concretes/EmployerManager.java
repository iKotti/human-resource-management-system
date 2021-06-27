package com.ikotti.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikotti.hrms.business.abstracts.EmployerVerificationService;
import com.ikotti.hrms.business.abstracts.EmployerService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.core.utilities.results.SuccessDataResult;
import com.ikotti.hrms.core.utilities.results.SuccessResult;
import com.ikotti.hrms.dataAccess.abstracts.EmployerDao;
import com.ikotti.hrms.entity.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	EmployerDao employerDao;
	EmployerVerificationService employerVerificationService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmployerVerificationService employerVerificationService) {
		this.employerDao = employerDao;
		this.employerVerificationService = employerVerificationService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(), "Data listelendi");
	}

	@Override
	public Result add(Employer employer) {
		
		Result checkTotal = employerVerificationService.checkTotal(employer);
		
		if(!checkTotal.isSuccess()) {
			return checkTotal;
		}
		
		employerDao.save(employer);
		return new SuccessResult("İş veren başarıyla eklendi.");
	}

	@Override
	public Result update(Employer employer) {
		Employer updatedEmployer = employerDao.getById(employer.getId());
		updatedEmployer = employer;
		employerDao.save(updatedEmployer);
		return new SuccessResult("İş veren başarıyla güncellendi.");
	}
	
	

}
