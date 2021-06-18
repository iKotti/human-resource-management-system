package com.ikotti.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ikotti.hrms.business.abstracts.JobPostingService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.ErrorResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.core.utilities.results.SuccessDataResult;
import com.ikotti.hrms.core.utilities.results.SuccessResult;
import com.ikotti.hrms.dataAccess.abstracts.JobPostingDao;
import com.ikotti.hrms.entity.concretes.JobPosting;
import com.ikotti.hrms.entity.dtos.JobPostingListDto;

@Service
public class JobPostingManager implements JobPostingService {

	private JobPostingDao jobPostingDao;

	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao) {
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public DataResult<List<JobPosting>> getAll() {
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.findAll(),"Tüm iş ilanları listelendi.");
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

	@Override
	public Result updateJobPostingActivation(int id, Boolean activationStatus) {
		JobPosting updateJobPosting = jobPostingDao.getById(id);
		if(updateJobPosting.getActivationStatus().equals(activationStatus)) {
			return new ErrorResult("Aktiflik durumu zaten girdiğiniz gibi.");
		}
		
		updateJobPosting.setActivationStatus(activationStatus);
		jobPostingDao.save(updateJobPosting);
		return new SuccessResult("İş ilanının aktiflik durumu güncellendi.");
	}

	@Override
	public DataResult<List<JobPostingListDto>> getJobPostingList() {
		return new SuccessDataResult<List<JobPostingListDto>>(this.jobPostingDao.getJobPostingList());
	}

	@Override
	public DataResult<JobPosting> getById(int id) {
		return new SuccessDataResult<JobPosting>(jobPostingDao.getById(id));
	}

	@Override
	public DataResult<List<JobPosting>> getByIsConfirm(Boolean isConfirm) {
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByIsConfirm(isConfirm));
	}
	
	
	
	
}
