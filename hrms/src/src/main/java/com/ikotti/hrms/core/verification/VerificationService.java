package com.ikotti.hrms.core.verification;

import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.abstacts.User;

public interface VerificationService {
	Result verificate(User user);
}
