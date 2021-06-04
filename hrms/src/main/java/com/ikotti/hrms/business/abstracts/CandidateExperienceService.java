package com.ikotti.hrms.business.abstracts;

import java.util.List;

import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.concretes.CandidateExperience;

public interface CandidateExperienceService {
	Result add(CandidateExperience candidateExperience, int candidateId);

	Result addAll(List<CandidateExperience> candidateExperiences,int candidateId);

	DataResult<List<CandidateExperience>> getAll();

	DataResult<List<CandidateExperience>> getAllByCandidateIdOrderByFinishDate(int candidateId);
}
