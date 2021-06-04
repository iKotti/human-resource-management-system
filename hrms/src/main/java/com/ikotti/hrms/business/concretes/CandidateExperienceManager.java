package com.ikotti.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ikotti.hrms.business.abstracts.CandidateExperienceService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.core.utilities.results.SuccessDataResult;
import com.ikotti.hrms.core.utilities.results.SuccessResult;
import com.ikotti.hrms.dataAccess.abstracts.CandidateDao;
import com.ikotti.hrms.dataAccess.abstracts.CandidateExperienceDao;
import com.ikotti.hrms.entity.concretes.Candidate;
import com.ikotti.hrms.entity.concretes.CandidateExperience;

@Service
public class CandidateExperienceManager implements CandidateExperienceService {

	private CandidateExperienceDao candidateExperienceDao;
	private CandidateDao candidateDao;

	public CandidateExperienceManager(CandidateExperienceDao candidateExperienceDao, CandidateDao candidateDao) {
		this.candidateExperienceDao = candidateExperienceDao;
		this.candidateDao = candidateDao;
	}

	@Override
	public Result add(CandidateExperience candidateExperience, int candidateId) {
		Candidate candidate = candidateDao.getById(candidateId);
		candidateExperience.setCandidate(candidate);
		this.candidateExperienceDao.save(candidateExperience);
		return new SuccessResult("Deneyim başarıyla eklendi.");
	}

	@Override
	public Result addAll(List<CandidateExperience> candidateExperiences, int candidateId) {
		Candidate candidate = candidateDao.getById(candidateId);
		candidateExperiences.forEach(candidateExperience -> candidateExperience.setCandidate(candidate));
		this.candidateExperienceDao.saveAll(candidateExperiences);
		return new SuccessResult("Deneyimler başarıyla eklendi.");
	}

	@Override
	public DataResult<List<CandidateExperience>> getAll() {
		return new SuccessDataResult<List<CandidateExperience>>(candidateExperienceDao.findAll());
	}

	@Override
	public DataResult<List<CandidateExperience>> getAllByCandidateIdOrderByFinishDate(int candidateId) {
		return new SuccessDataResult<List<CandidateExperience>>(
				candidateExperienceDao.getAllByCandidateIdOrderByFinishDate(candidateId));
	}

}
