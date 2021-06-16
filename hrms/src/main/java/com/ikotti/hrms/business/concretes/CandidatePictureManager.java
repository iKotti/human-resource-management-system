package com.ikotti.hrms.business.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ikotti.hrms.business.abstracts.CandidatePictureService;
import com.ikotti.hrms.core.utilities.pictureService.PictureService;
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
    private PictureService pictureService;

    @Autowired
    public CandidatePictureManager(CandidatePictureDao candidatePictureDao, CandidateDao candidateDao,PictureService pictureService) {
		this.candidatePictureDao = candidatePictureDao;
		this.candidateDao = candidateDao;
		this.pictureService = pictureService;
	}
    
    @Override
    public Result add(int candidateId, MultipartFile file) {
    	CandidatePicture candidatePicture = new CandidatePicture();
    	Candidate candidate = candidateDao.getById(candidateId);
    	candidatePicture.setCandidate(candidate);
    	
    	Map<String, String> result = (Map<String, String>) pictureService.save(file).getData();
        String url = result.get("url");
        candidatePicture.setUrl(url);
        
        candidatePicture.setUploadedDate(LocalDate.now());
    	
        this.candidatePictureDao.save(candidatePicture);
        return new SuccessResult();
    }
    
    @Override
	public Result addAll(List<CandidatePicture> candidatePictures, int candidateId) {
    	Candidate candidate = candidateDao.getById(candidateId);
    	candidatePictures.forEach(candidatePicture -> candidatePicture.setCandidate(candidate));
		candidatePictureDao.saveAll(candidatePictures);
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
