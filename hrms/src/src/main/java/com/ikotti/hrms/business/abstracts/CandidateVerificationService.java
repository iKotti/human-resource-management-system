package com.ikotti.hrms.business.abstracts;

import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.concretes.Candidate;

public interface CandidateVerificationService {
	Result checkNullInput(Candidate candidate);
	
	Result checkRegisteredEmail(String email);

	Result checkRegisteredNationalIdentity(String nationalIdentity);

	Result emailValid(String email);
	
	Result checkTotal(Candidate candidate);
}
