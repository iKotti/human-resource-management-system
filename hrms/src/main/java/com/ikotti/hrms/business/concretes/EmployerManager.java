package com.ikotti.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikotti.hrms.business.abstracts.AuthServiceEmployer;
import com.ikotti.hrms.business.abstracts.EmployerService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.core.utilities.results.SuccessDataResult;
import com.ikotti.hrms.core.utilities.results.SuccessResult;
import com.ikotti.hrms.core.verification.VerificationService;
import com.ikotti.hrms.dataAccess.abstracts.EmployerDao;
import com.ikotti.hrms.entity.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	EmployerDao employerDao;
	AuthServiceEmployer authServiceEmployer;
	VerificationService verificationService;

	@Autowired
	public EmployerManager(EmployerDao employerDao,AuthServiceEmployer authServiceEmployer,VerificationService verificationService) {
		this.employerDao = employerDao;
		this.authServiceEmployer = authServiceEmployer;
		this.verificationService = verificationService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>
		(employerDao.findAll(),"Data listelendi");
	}

	@Override
	public Result add(Employer employer) {
		Result checkNullInput = authServiceEmployer.checkNullInput(employer);
		Result checkRegisteredEmail = authServiceEmployer.checkRegisteredEmail(employer.getEmail());
		Result emailValid = authServiceEmployer.emailValid(employer.getEmail(), employer.getCompanyName(),employer.getWebAdress());
		Result emailIsVerificate = verificationService.emailIsVerificate(employer.getEmail());
		Result employerIsVerificateByEmployee = verificationService.employerIsVerificateByEmployee(employer.getId());
		
		Result[] results = {checkNullInput,checkRegisteredEmail,emailValid,emailIsVerificate,employerIsVerificateByEmployee};
		
		for(Result result:results) {
			if(!result.isSuccess()) {
				return result;
			}
		}

		employerDao.save(employer);
		return new SuccessResult("İş veren başarıyla eklendi.");
	}
	
	

}
