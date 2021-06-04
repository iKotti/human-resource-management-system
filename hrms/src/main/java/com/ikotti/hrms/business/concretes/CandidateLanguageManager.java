package com.ikotti.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ikotti.hrms.business.abstracts.CandidateLanguageService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.core.utilities.results.SuccessDataResult;
import com.ikotti.hrms.core.utilities.results.SuccessResult;
import com.ikotti.hrms.dataAccess.abstracts.CandidateDao;
import com.ikotti.hrms.dataAccess.abstracts.CandidateLanguageDao;
import com.ikotti.hrms.entity.concretes.Candidate;
import com.ikotti.hrms.entity.concretes.CandidateLanguage;

@Service
public class CandidateLanguageManager implements CandidateLanguageService {

	private CandidateLanguageDao candidateLanguageDao;
	private CandidateDao candidateDao;

	@Autowired
	public CandidateLanguageManager(CandidateLanguageDao candidateLanguageDao, CandidateDao candidateDao) {
		this.candidateLanguageDao = candidateLanguageDao;
		this.candidateDao = candidateDao;
	}

	@Override
	public Result add(@RequestBody CandidateLanguage candidateLanguage, int candidateId) {
		Candidate candidate = candidateDao.getById(candidateId);
		candidateLanguage.setCandidate(candidate);
		candidateLanguageDao.save(candidateLanguage);
		return new SuccessResult("Dil bilgisi başarıyla eklendi.");
	}

	@Override
	public Result addAll(List<CandidateLanguage> candidateLanguages, int candidateId) {
		Candidate candidate = candidateDao.getById(candidateId);
		candidateLanguages.forEach(candidateLanguage -> candidateLanguage.setCandidate(candidate));
		candidateLanguageDao.saveAll(candidateLanguages);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<CandidateLanguage>> getAll() {
		return new SuccessDataResult<>(candidateLanguageDao.findAll());
	}

	@Override
	public DataResult<List<CandidateLanguage>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<>(candidateLanguageDao.getAllByCandidateId(candidateId));
	}

}
