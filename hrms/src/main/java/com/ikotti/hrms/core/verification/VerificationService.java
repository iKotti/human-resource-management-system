package com.ikotti.hrms.core.verification;

import com.ikotti.hrms.core.utilities.results.Result;

public interface VerificationService {
	Result emailIsVerificate(String email);
	Result employerIsVerificateByEmployee(int id);
}
