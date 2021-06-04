package com.ikotti.hrms.business.abstracts;

import java.util.List;

import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.concretes.CandidateSocialMedia;

public interface CandidateSocialMediaService {
	Result add(CandidateSocialMedia candidateSocialMedia,int candidateId);

	Result addAll(List<CandidateSocialMedia> candidateSocialMedias,int candidateId);

	DataResult<List<CandidateSocialMedia>> getAll();

	DataResult<List<CandidateSocialMedia>> getAllByCandidateId(int candidateId);
}
