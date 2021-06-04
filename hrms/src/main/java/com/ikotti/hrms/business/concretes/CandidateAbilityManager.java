package com.ikotti.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikotti.hrms.business.abstracts.CandidateAbilityService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.core.utilities.results.SuccessDataResult;
import com.ikotti.hrms.core.utilities.results.SuccessResult;
import com.ikotti.hrms.dataAccess.abstracts.CandidateAbilityDao;
import com.ikotti.hrms.dataAccess.abstracts.CandidateDao;
import com.ikotti.hrms.entity.concretes.Candidate;
import com.ikotti.hrms.entity.concretes.CandidateAbility;

@Service
public class CandidateAbilityManager implements CandidateAbilityService {

	private CandidateAbilityDao candidateAbilityDao;
	private CandidateDao candidateDao;

	@Autowired
	public CandidateAbilityManager(CandidateAbilityDao candidateAbilityDao, CandidateDao candidateDao) {
		this.candidateAbilityDao = candidateAbilityDao;
		this.candidateDao = candidateDao;
	}

	@Override
	public Result add(CandidateAbility candidateAbility, int candidateId) {
		Candidate candidate = candidateDao.getById(candidateId);
		candidateAbility.setCandidate(candidate);
		candidateAbilityDao.save(candidateAbility);
		return new SuccessResult("Yetenek başarıyla eklendi.");
	}

	@Override
	public Result addAll(List<CandidateAbility> candidateAbilities, int candidateId) {
		Candidate candidate = candidateDao.getById(candidateId);
		candidateAbilities.forEach(candidateAbility -> candidateAbility.setCandidate(candidate));
		candidateAbilityDao.saveAll(candidateAbilities);
		return new SuccessResult("Yetenekler başarıyla eklendi.");
	}

	@Override
	public DataResult<List<CandidateAbility>> getAll() {
		return new SuccessDataResult<List<CandidateAbility>>(candidateAbilityDao.findAll());
	}

	@Override
	public DataResult<List<CandidateAbility>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<CandidateAbility>>(candidateAbilityDao.getAllByCandidateId(candidateId));
	}

}
