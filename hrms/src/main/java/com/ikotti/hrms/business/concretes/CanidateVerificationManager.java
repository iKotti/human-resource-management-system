package com.ikotti.hrms.business.concretes;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikotti.hrms.business.abstracts.CandidateVerificationService;
import com.ikotti.hrms.business.abstracts.EmailService;
import com.ikotti.hrms.business.abstracts.UserService;
import com.ikotti.hrms.core.utilities.adaptors.ValidationService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.ErrorResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.core.utilities.results.SuccessDataResult;
import com.ikotti.hrms.core.utilities.results.SuccessResult;
import com.ikotti.hrms.dataAccess.abstracts.CandidateDao;
import com.ikotti.hrms.entity.concretes.Candidate;

@Service
public class CanidateVerificationManager implements CandidateVerificationService {

	private CandidateDao candidateDao;
	private UserService userService;
	private ValidationService validationService;
	private EmailService emailService;

	@Autowired
	public CanidateVerificationManager(CandidateDao candidateDao, UserService userService,
			ValidationService validationService, EmailService emailService) {
		this.candidateDao = candidateDao;
		this.userService = userService;
		this.validationService = validationService;
		this.emailService = emailService;
	}

	@Override
	public Result checkTotal(Candidate candidate) {
		Result checkNullInput = checkNullInput(candidate);
		Result emailValid = emailValid(candidate.getEmail());
		Result checkRegisteredEmail = checkRegisteredEmail(candidate.getEmail());
		Result checkRegisteredNationalIdentity = checkRegisteredNationalIdentity(candidate.getNationalIdentity());
		Result checkIfRealPerson = validationService.checkIfRealPerson(candidate.getNationalIdentity(),
				candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate());
		Result emailConfirmation = emailService.confirmation(candidate.getEmail());

		Result[] results = { checkNullInput, emailValid, checkRegisteredEmail, checkRegisteredNationalIdentity,
				checkIfRealPerson, emailConfirmation };

		for (Result result : results) {
			if (!result.isSuccess()) {
				return result;
			}
		}
		return new SuccessResult();
	}

	@Override
	public Result checkNullInput(Candidate candidate) {

		if (candidate.getEmail().strip().equals("") || candidate.getPassword().strip().equals("")
				|| candidate.getFirstName().strip().equals("") || candidate.getLastName().strip().equals("")
				|| candidate.getNationalIdentity().strip().equals("") || candidate.getBirthDate() == null) {
			return new ErrorResult("Lütfen tüm alanları doldurunuz.");
		}
		return new SuccessResult();
	}

	@Override
	public Result checkRegisteredNationalIdentity(String nationalIdentity) {
		if (getByNationalIdentity(nationalIdentity).getData() != null) {

			return new ErrorResult("Bu kimlik zaten kayıtlı");
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
	public Result emailValid(String email) {
		Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
				Pattern.CASE_INSENSITIVE);

		Boolean emailMatcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email).find();

		if (!emailMatcher) {
			return new ErrorResult("Geçersiz email adresi");
		}
		return new SuccessResult();

	}

	public DataResult<Candidate> getByNationalIdentity(String nationalIdentity) {
		return new SuccessDataResult<Candidate>(candidateDao.findByNationalIdentity(nationalIdentity));
	}

}
