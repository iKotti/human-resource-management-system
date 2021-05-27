package com.ikotti.hrms.business.abstracts;

import com.ikotti.hrms.core.utilities.results.Result;

public interface EmailService {
	Result confirmation(String email);

}
