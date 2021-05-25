package com.ikotti.hrms.core.verification;

import org.springframework.stereotype.Service;

import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.core.utilities.results.SuccessResult;

@Service
public class VerificationManager implements VerificationService{

	@Override
	public Result emailIsVerificate(String email) {
		return new SuccessResult(email + " e-postası başarıyla doğrulandı.");
	}
	
	@Override
	public Result employerIsVerificateByEmployee(int id) {
		return new SuccessResult();
	}
}
