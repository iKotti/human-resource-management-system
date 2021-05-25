package com.ikotti.hrms.business.abstracts;

import com.ikotti.hrms.core.utilities.results.Result;

public interface JobPositionControl {
	Result checkRegisteredTitle(String title);
}
