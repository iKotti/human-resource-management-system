package com.ikotti.hrms.business.abstracts;

import java.util.List;

import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.concretes.CandidatePicture;

public interface CandidatePictureService {
	Result add(CandidatePicture candidatePicture, int candidateId);

	DataResult<List<CandidatePicture>> getAll();

	DataResult<List<CandidatePicture>> getAllByCandidateId(int candidateId);
}
