package com.ikotti.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.dtos.CurriculumVitaeDto;

public interface CurriculumVitaeService {
	Result add(CurriculumVitaeDto curriculumVitaeDto, int candidateId);
}
