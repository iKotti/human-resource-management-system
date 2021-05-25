package com.ikotti.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikotti.hrms.business.abstracts.AuthServiceCandidate;
import com.ikotti.hrms.business.abstracts.CandidateService;
import com.ikotti.hrms.core.utilities.adaptors.ValidationService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.core.utilities.results.SuccessDataResult;
import com.ikotti.hrms.core.utilities.results.SuccessResult;
import com.ikotti.hrms.core.verification.VerificationService;
import com.ikotti.hrms.dataAccess.abstracts.CandidateDao;
import com.ikotti.hrms.entity.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	CandidateDao candidateDao;
	AuthServiceCandidate authServiceCandidate;
	ValidationService validationService;
	VerificationService verificationService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, AuthServiceCandidate authServiceCandidate,
			ValidationService validationService, VerificationService verificationService) {
		this.candidateDao = candidateDao;
		this.authServiceCandidate = authServiceCandidate;
		this.validationService = validationService;
		this.verificationService = verificationService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(Candidate candidate) {
		Result checkNullInput = authServiceCandidate.checkNullInput(candidate);
		Result emailValid = authServiceCandidate.emailValid(candidate.getEmail());
		Result checkRegisteredEmail = authServiceCandidate.checkRegisteredEmail(candidate.getEmail());
		Result checkRegisteredNationalIdentity = authServiceCandidate
				.checkRegisteredNationalIdentity(candidate.getNationalIdentity());
		Result emailIsVerificate = verificationService.emailIsVerificate(candidate.getEmail());
		Result checkIfRealPerson = validationService.checkIfRealPerson(candidate.getNationalIdentity(),
				candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate());

		Result[] results = { checkNullInput, emailValid, checkRegisteredEmail, checkRegisteredNationalIdentity,
				emailIsVerificate,checkIfRealPerson };

		for (Result result : results) {
			if (!result.isSuccess()) {
				return result;
			}
		}
		this.candidateDao.save(candidate);
		return new SuccessResult("İş arayan başarıyla kaydedildi.");
	}

}
