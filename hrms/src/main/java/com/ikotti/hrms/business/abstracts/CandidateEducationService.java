package com.ikotti.hrms.business.abstracts;

import java.util.List;

import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.concretes.CandidateEducation;

public interface CandidateEducationService {
	Result add(CandidateEducation candidateEducation, int candidateId);

	Result addAll(List<CandidateEducation> candidateEducations, int candidateId);

	DataResult<List<CandidateEducation>> getAll();

	DataResult<List<CandidateEducation>> getAllOrderByFinishYearAsc();

}
