package com.ikotti.hrms.business.abstracts;

import java.util.List;

import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.entity.abstacts.User;

public interface UserService {
	DataResult<List<User>> getAll();
	DataResult<User> getByEmail(String email);
}
