package com.ikotti.hrms.core.verification;

import org.springframework.stereotype.Service;

import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.core.utilities.results.SuccessResult;
import com.ikotti.hrms.entity.abstacts.User;

@Service
public class EmployerIsVerificateByEmployee implements VerificationService{
	@Override
	public Result verificate(User user) {
		return new SuccessResult();
	}
	
	public Result verificateUpdate(User user) {
		return new SuccessResult();
	}
}
