package com.ikotti.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikotti.hrms.business.abstracts.CandidateEducationService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.core.utilities.results.SuccessDataResult;
import com.ikotti.hrms.core.utilities.results.SuccessResult;
import com.ikotti.hrms.dataAccess.abstracts.CandidateDao;
import com.ikotti.hrms.dataAccess.abstracts.CandidateEducationDao;
import com.ikotti.hrms.entity.concretes.Candidate;
import com.ikotti.hrms.entity.concretes.CandidateEducation;


@Service
public class CandidateEducationManager implements CandidateEducationService {

	private CandidateEducationDao candidateEducationDao;
	private CandidateDao candidateDao;

	
	@Autowired
	public CandidateEducationManager(CandidateEducationDao candidateEducationDao, CandidateDao candidateDao) {
		this.candidateEducationDao = candidateEducationDao;
		this.candidateDao = candidateDao;
	}

	@Override
	public Result add(CandidateEducation candidateEducation, int candidateId) {
		Candidate candidate = candidateDao.getById(candidateId);
		candidateEducation.setCandidate(candidate);
		candidateEducationDao.save(candidateEducation);
		return new SuccessResult("Okul bilgisi başarıyla eklendi.");
	}

	@Override
	public Result addAll(List<CandidateEducation> candidateEducations, int candidateId) {
		Candidate candidate = candidateDao.getById(candidateId);
		candidateEducations.forEach(candidateEducation -> candidateEducation.setCandidate(candidate));
		candidateEducationDao.saveAll(candidateEducations);
		return new SuccessResult("Okul bilgileri başarıyla eklendi.");
	}

	@Override
	public DataResult<List<CandidateEducation>> getAll() {
		return new SuccessDataResult<>(this.candidateEducationDao.findAll());
	}	

	@Override
	public DataResult<List<CandidateEducation>> getAllOrderByFinishYearAsc() {
		return new SuccessDataResult<>(this.candidateEducationDao.getAllByOrderByFinishYearAsc(),
				"Mezuniyet yılına göre listelendi.");
	}

}
