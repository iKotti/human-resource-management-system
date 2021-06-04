package com.ikotti.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikotti.hrms.business.abstracts.CandidatePictureService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.core.utilities.results.SuccessDataResult;
import com.ikotti.hrms.core.utilities.results.SuccessResult;
import com.ikotti.hrms.dataAccess.abstracts.CandidateDao;
import com.ikotti.hrms.dataAccess.abstracts.CandidatePictureDao;
import com.ikotti.hrms.entity.concretes.Candidate;
import com.ikotti.hrms.entity.concretes.CandidatePicture;

@Service
public class CandidatePictureManager implements CandidatePictureService{

    private CandidatePictureDao candidatePictureDao;
    private CandidateDao candidateDao;

    @Autowired
    public CandidatePictureManager(CandidatePictureDao candidatePictureDao, CandidateDao candidateDao) {
		this.candidatePictureDao = candidatePictureDao;
		this.candidateDao = candidateDao;
	}
    
    @Override
    public Result add(CandidatePicture candidatePicture,int candidateId) {
    	Candidate candidate = candidateDao.getById(candidateId);
    	candidatePicture.setCandidate(candidate);
        this.candidatePictureDao.save(candidatePicture);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<CandidatePicture>> getAll() {
        return new SuccessDataResult<>(candidatePictureDao.findAll());
    }

    @Override
    public DataResult<List<CandidatePicture>> getAllByCandidateId(int candidateId) {
        return new SuccessDataResult<>(candidatePictureDao.getAllByCandidateId(candidateId));
    }

}
