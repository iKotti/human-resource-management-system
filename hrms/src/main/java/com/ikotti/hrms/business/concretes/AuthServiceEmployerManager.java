package com.ikotti.hrms.business.concretes;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikotti.hrms.business.abstracts.AuthServiceEmployer;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.ErrorResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.core.utilities.results.SuccessDataResult;
import com.ikotti.hrms.core.utilities.results.SuccessResult;
import com.ikotti.hrms.dataAccess.abstracts.EmployerDao;
import com.ikotti.hrms.entity.concretes.Employer;

@Service
public class AuthServiceEmployerManager implements AuthServiceEmployer {

	private EmployerDao employerDao;

	@Autowired
	public AuthServiceEmployerManager(EmployerDao employerDao) {
		this.employerDao = employerDao;
	}

	@Override
	public Result checkNullInput(Employer employer) {
		if (employer.getCompanyName().strip().equals("") || employer.getEmail().strip().equals("")
				|| employer.getPassword().strip().equals("") || employer.getWebAdress().strip().equals("")
				|| employer.getPhoneNumber().strip().equals("")) {
			return new ErrorResult("Lütfen tüm alanları doldurunuz.");
		}
		return new SuccessResult();
	}

	@Override
	public Result checkRegisteredEmail(String email) {

		if (getByEmail(email).getData() != null) {
			return new ErrorResult("Bu email adresi zaten kayıtlı");
		}
		return new SuccessResult();
	}

	@Override
	public Result emailValid(String email,String companyName, String webAddress) {
		
		Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@" + companyName +"+\\.[A-Z]{2,6}$",
				Pattern.CASE_INSENSITIVE);
		
		Pattern VALID_DOMAIN_REGEX = Pattern.compile("^[A-Z0-9._%+-]+." + companyName +"+\\.[A-Z]{2,6}$",
				Pattern.CASE_INSENSITIVE);
		
		Boolean emailMatcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email).find();
		Boolean domainMatcher = VALID_DOMAIN_REGEX.matcher(webAddress).find();
		
		if(!emailMatcher) {
			return new ErrorResult("Şirket e-postası şirket adı ile uyuşmuyor.");
		}else if(!domainMatcher) {
			return new ErrorResult("Şirket e-postası domain ile uyuşmuyor.");
		}
		return new SuccessResult();
	}

	public DataResult<Employer> getByEmail(String email) {
		return new SuccessDataResult<Employer>(employerDao.findByEmail(email));
	}

}
