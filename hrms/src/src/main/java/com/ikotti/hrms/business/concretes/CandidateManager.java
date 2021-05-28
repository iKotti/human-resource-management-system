package com.ikotti.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikotti.hrms.business.abstracts.CandidateVerificationService;
import com.ikotti.hrms.business.abstracts.CandidateService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.core.utilities.results.SuccessDataResult;
import com.ikotti.hrms.core.utilities.results.SuccessResult;
import com.ikotti.hrms.dataAccess.abstracts.CandidateDao;
import com.ikotti.hrms.entity.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	CandidateDao candidateDao;
	CandidateVerificationService candidateVerificationService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, CandidateVerificationService candidateVerificationService) {
		this.candidateDao = candidateDao;
		this.candidateVerificationService = candidateVerificationService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(Candidate candidate) {
		
		Result checkTotal = candidateVerificationService.checkTotal(candidate);
		
		if(!checkTotal.isSuccess()) {
			return checkTotal;
		}
		
		this.candidateDao.save(candidate);
		return new SuccessResult("İş arayan başarıyla kaydedildi.");
	}

}
