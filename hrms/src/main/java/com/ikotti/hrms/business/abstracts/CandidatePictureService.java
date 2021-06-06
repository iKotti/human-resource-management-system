package com.ikotti.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.concretes.CandidatePicture;

public interface CandidatePictureService {
	Result add(int candidateId, MultipartFile file);

	DataResult<List<CandidatePicture>> getAll();

	DataResult<List<CandidatePicture>> getAllByCandidateId(int candidateId);
}
