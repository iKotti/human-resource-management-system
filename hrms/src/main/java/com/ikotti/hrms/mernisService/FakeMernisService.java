package com.ikotti.hrms.mernisService;

import java.time.LocalDate;

public class FakeMernisService {
	public boolean fakeMernisService(String nationalIdentity, String firstName, String lastName, LocalDate birthDate) {

		System.out.println(nationalIdentity + " Kimlik no'lu " + firstName + " " + lastName + " kayıt için uygundur.");
		return true;
	}
}
