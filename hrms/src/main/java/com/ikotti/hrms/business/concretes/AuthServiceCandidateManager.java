package com.ikotti.hrms.business.concretes;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikotti.hrms.business.abstracts.AuthServiceCandidate;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.ErrorResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.core.utilities.results.SuccessDataResult;
import com.ikotti.hrms.core.utilities.results.SuccessResult;
import com.ikotti.hrms.dataAccess.abstracts.CandidateDao;
import com.ikotti.hrms.entity.concretes.Candidate;

@Service
public class AuthServiceCandidateManager implements AuthServiceCandidate {

	private CandidateDao candidateDao;

	@Autowired
	public AuthServiceCandidateManager(CandidateDao candidateDao) {
		this.candidateDao = candidateDao;
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
		if (getByEmail(email).getData() != null) {

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
	
	public DataResult<Candidate> getByNationalIdentity(String nationalIdentity){
		return new SuccessDataResult<Candidate>(candidateDao.findByNationalIdentity(nationalIdentity));
	}

	public DataResult<Candidate> getByEmail(String email) {
		return new SuccessDataResult<Candidate>(candidateDao.findByEmail(email));
	}

}
