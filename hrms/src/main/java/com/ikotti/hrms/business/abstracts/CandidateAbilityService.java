package com.ikotti.hrms.business.abstracts;

import java.util.List;

import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.concretes.CandidateAbility;

public interface CandidateAbilityService {
	Result add(CandidateAbility candidateAbility, int candidateId);

	Result addAll(List<CandidateAbility> candidateAbility, int candidateId);

	DataResult<List<CandidateAbility>> getAll();

	DataResult<List<CandidateAbility>> getAllByCandidateId(int candidateId);
}