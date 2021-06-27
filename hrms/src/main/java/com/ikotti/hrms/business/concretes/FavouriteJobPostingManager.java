package com.ikotti.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikotti.hrms.business.abstracts.FavouriteJobPostingService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.core.utilities.results.SuccessDataResult;
import com.ikotti.hrms.core.utilities.results.SuccessResult;
import com.ikotti.hrms.dataAccess.abstracts.CandidateDao;
import com.ikotti.hrms.dataAccess.abstracts.FavouriteJobPostingDao;
import com.ikotti.hrms.dataAccess.abstracts.JobPostingDao;
import com.ikotti.hrms.entity.concretes.Candidate;
import com.ikotti.hrms.entity.concretes.FavouriteJobPosting;
import com.ikotti.hrms.entity.concretes.JobPosting;

@Service
public class FavouriteJobPostingManager implements FavouriteJobPostingService {

	private FavouriteJobPostingDao favouriteJobPostingDao;
	private CandidateDao candidateDao;
	private JobPostingDao jobPostingDao;

	@Autowired
	public FavouriteJobPostingManager(FavouriteJobPostingDao favouriteJobPostingDao, CandidateDao candidateDao,
			JobPostingDao jobPostingDao) {
		this.favouriteJobPostingDao = favouriteJobPostingDao;
		this.candidateDao = candidateDao;
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public Result add(int candidateId, int jobPostingId) {
		Candidate candidate = candidateDao.getById(candidateId);
		JobPosting jobPosting = jobPostingDao.getById(jobPostingId);

		FavouriteJobPosting favouriteJobPosting = new FavouriteJobPosting();
		favouriteJobPosting.setCandidate(candidate);
		favouriteJobPosting.setJobPosting(jobPosting);
		favouriteJobPostingDao.save(favouriteJobPosting);

		return new SuccessResult("İş ilanı başarıyla favoriye eklendi");
	}

	@Override
	public DataResult<List<FavouriteJobPosting>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<FavouriteJobPosting>>(
				favouriteJobPostingDao.getAllByCandidateId(candidateId));
	}

}
