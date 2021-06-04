package com.ikotti.hrms.business.concretes;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikotti.hrms.business.abstracts.EmailService;
import com.ikotti.hrms.business.abstracts.EmployerVerificationService;
import com.ikotti.hrms.business.abstracts.UserService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.ErrorResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.core.utilities.results.SuccessDataResult;
import com.ikotti.hrms.core.utilities.results.SuccessResult;
import com.ikotti.hrms.core.verification.VerificationService;
import com.ikotti.hrms.dataAccess.abstracts.EmployerDao;
import com.ikotti.hrms.entity.concretes.Employer;

@Service
public class EmployerVerificationManager implements EmployerVerificationService {

	private EmployerDao employerDao;
	private UserService userService;
	private EmailService emailService;
	private VerificationService verificationService;

	@Autowired
	public EmployerVerificationManager(EmployerDao employerDao, UserService userService, EmailService emailService,
			VerificationService verificationService) {
		this.employerDao = employerDao;
		this.userService = userService;
		this.emailService = emailService;
		this.verificationService = verificationService;
	}

	@Override
	public Result checkTotal(Employer employer) {
		Result checkNullInput = checkNullInput(employer);
		Result checkRegisteredEmail = checkRegisteredEmail(employer.getEmail());
		Result emailValid = emailValid(employer.getEmail(), employer.getCompanyName(), employer.getWebAdress());
		Result emailConfirmation = emailService.confirmation(employer.getEmail());
		Result confirmedByEmployee = verificationService.verificate(employer);

		Result[] results = { checkNullInput, emailValid, checkRegisteredEmail, emailConfirmation, confirmedByEmployee };

		for (Result result : results) {
			if (!result.isSuccess()) {
				return result;
			}
		}

		return new SuccessResult();
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

		if (userService.getByEmail(email).getData() != null) {
			return new ErrorResult("Bu email adresi zaten kayıtlı");
		}
		return new SuccessResult();
	}

	@Override
	public Result emailValid(String email, String companyName, String webAddress) {

		Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@" + companyName + "+\\.[A-Z]{2,6}$",
				Pattern.CASE_INSENSITIVE);

		Pattern VALID_DOMAIN_REGEX = Pattern.compile("^[A-Z0-9._%+-]+." + companyName + "+\\.[A-Z]{2,6}$",
				Pattern.CASE_INSENSITIVE);

		Boolean emailMatcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email).find();
		Boolean domainMatcher = VALID_DOMAIN_REGEX.matcher(webAddress).find();

		if (!emailMatcher) {
			return new ErrorResult("Şirket e-postası şirket adı ile uyuşmuyor.");
		} else if (!domainMatcher) {
			return new ErrorResult("Şirket e-postası domain ile uyuşmuyor.");
		}
		return new SuccessResult();
	}

	public DataResult<Employer> getByEmail(String email) {
		return new SuccessDataResult<Employer>(employerDao.getByEmail(email));
	}

}
