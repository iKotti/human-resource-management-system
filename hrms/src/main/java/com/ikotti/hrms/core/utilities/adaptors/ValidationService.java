package com.ikotti.hrms.core.utilities.adaptors;

import java.time.LocalDate;

import com.ikotti.hrms.core.utilities.results.Result;

public interface ValidationService {
	Result checkIfRealPerson(String nationalIdentity, String firstName, String lastName, LocalDate birthDate);
}
