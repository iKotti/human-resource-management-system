package com.ikotti.hrms.business.abstracts;

import java.util.List;

import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.concretes.FavouriteJobPosting;

public interface FavouriteJobPostingService {
	Result add(int candidateId, int jobPostingId);

	DataResult<List<FavouriteJobPosting>> getAllByCandidateId(int candidateId);
}
