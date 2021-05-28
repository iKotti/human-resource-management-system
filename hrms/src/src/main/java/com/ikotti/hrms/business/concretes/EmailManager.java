package com.ikotti.hrms.business.concretes;

import org.springframework.stereotype.Service;

import com.ikotti.hrms.business.abstracts.EmailService;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.core.utilities.results.SuccessResult;

@Service
public class EmailManager implements EmailService{

	@Override
	public Result confirmation(String email) {
		return new SuccessResult(email + " adresi başarıyla doğrulandı.");
	}
}
