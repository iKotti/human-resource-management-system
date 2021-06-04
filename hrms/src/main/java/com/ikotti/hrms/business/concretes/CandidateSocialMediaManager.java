package com.ikotti.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikotti.hrms.business.abstracts.CandidateSocialMediaService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.core.utilities.results.SuccessDataResult;
import com.ikotti.hrms.core.utilities.results.SuccessResult;
import com.ikotti.hrms.dataAccess.abstracts.CandidateDao;
import com.ikotti.hrms.dataAccess.abstracts.CandidateSocialMediaDao;
import com.ikotti.hrms.entity.concretes.Candidate;
import com.ikotti.hrms.entity.concretes.CandidateSocialMedia;

@Service
public class CandidateSocialMediaManager implements CandidateSocialMediaService {

	private CandidateSocialMediaDao candidateSocialMediaDao;
	private CandidateDao candidateDao;

	@Autowired
	public CandidateSocialMediaManager(CandidateSocialMediaDao candidateSocialMediaDao, CandidateDao candidateDao) {
		this.candidateSocialMediaDao = candidateSocialMediaDao;
		this.candidateDao = candidateDao;
	}

	@Override
	public Result add(CandidateSocialMedia candidateSocialMedia,int candidateId) {
		Candidate candidate = candidateDao.getById(candidateId);
		candidateSocialMedia.setCandidate(candidate);
		candidateSocialMediaDao.save(candidateSocialMedia);
		return new SuccessResult("Sosyal medya başarıyla eklendi.");
	}

	@Override
	public Result addAll(List<CandidateSocialMedia> candidateSocialMedias,int candidateId) {
		Candidate candidate = candidateDao.getById(candidateId);
		candidateSocialMedias.forEach(candidateSocialMedia -> candidateSocialMedia.setCandidate(candidate));
		candidateSocialMediaDao.saveAll(candidateSocialMedias);
		return new SuccessResult("Sosyal medyalar başarıyla eklendi.");
	}

	@Override
	public DataResult<List<CandidateSocialMedia>> getAll() {
		return new SuccessDataResult<List<CandidateSocialMedia>>(candidateSocialMediaDao.findAll());
	}

	@Override
	public DataResult<List<CandidateSocialMedia>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<CandidateSocialMedia>>(
				candidateSocialMediaDao.getAllByCandidateId(candidateId));
	}

}
