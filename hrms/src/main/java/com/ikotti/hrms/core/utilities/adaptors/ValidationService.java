package com.ikotti.hrms.core.utilities.adaptors;

import java.util.Date;

import com.ikotti.hrms.core.utilities.results.Result;

public interface ValidationService {
	Result checkIfRealPerson(String nationalIdentity, String firstName, String lastName, Date birthDate);
}
