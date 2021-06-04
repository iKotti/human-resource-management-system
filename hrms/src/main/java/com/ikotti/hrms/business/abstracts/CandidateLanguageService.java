package com.ikotti.hrms.business.abstracts;

import java.util.List;

import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.concretes.CandidateLanguage;

public interface CandidateLanguageService {
	Result add(CandidateLanguage candidateLanguage,int candidateId);

	Result addAll(List<CandidateLanguage> candidateLanguages,int candidateId);

	DataResult<List<CandidateLanguage>> getAll();

	DataResult<List<CandidateLanguage>> getAllByCandidateId(int candidateId);
}
