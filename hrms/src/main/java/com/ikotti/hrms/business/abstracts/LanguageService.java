package com.ikotti.hrms.business.abstracts;

import java.util.List;

import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.concretes.Language;

public interface LanguageService {
	Result add(Language language);

	DataResult<List<Language>> getAll();
}
