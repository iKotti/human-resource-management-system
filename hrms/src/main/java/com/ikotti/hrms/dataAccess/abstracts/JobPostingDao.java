package com.ikotti.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikotti.hrms.entity.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{
	List<JobPosting> getByEmployer_CompanyName(String companyName);
	JobPosting getById(int id);
}
