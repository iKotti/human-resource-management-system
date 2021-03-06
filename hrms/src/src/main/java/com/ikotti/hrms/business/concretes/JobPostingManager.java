package com.ikotti.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ikotti.hrms.business.abstracts.JobPostingService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.core.utilities.results.SuccessDataResult;
import com.ikotti.hrms.core.utilities.results.SuccessResult;
import com.ikotti.hrms.dataAccess.abstracts.JobPostingDao;
import com.ikotti.hrms.entity.concretes.JobPosting;

@Service
public class JobPostingManager implements JobPostingService {

	private JobPostingDao jobPostingDao;

	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao) {
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public DataResult<List<JobPosting>> getAll() {
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.findAll(), "İş ilanları listelendi.");
	}

	@Override
	public Result add(JobPosting jobPosting) {
		jobPostingDao.save(jobPosting);
		return new SuccessResult("İş ilanı başarıyla eklendi.");
	}

	@Override
	public DataResult<List<JobPosting>> getSortedByCreationDate() {
		Sort sort = Sort.by(Sort.Direction.ASC, "creationDate");
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(sort), "Sıralama başarılı");
	}

	@Override
	public DataResult<List<JobPosting>> getByCompanyName(String companyName) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByEmployer_CompanyName(companyName),
				"Firma adına göre listelendi.");
	}

}
