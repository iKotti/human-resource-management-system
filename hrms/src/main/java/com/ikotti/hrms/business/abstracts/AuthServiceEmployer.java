package com.ikotti.hrms.business.abstracts;

import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.concretes.Employer;

public interface AuthServiceEmployer {
	Result checkNullInput(Employer employer);

	Result checkRegisteredEmail(String email);

	Result emailValid(String email,String companyName,String webAdress);

}
