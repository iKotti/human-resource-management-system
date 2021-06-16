package com.ikotti.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ikotti.hrms.entity.concretes.JobPosting;
import com.ikotti.hrms.entity.dtos.JobPostingListDto;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{
	List<JobPosting> getByEmployer_CompanyName(String companyName);
	JobPosting getById(int id);
	
	@Query("Select new com.ikotti.hrms.entity.dtos.JobPostingListDto"
			+ "(j.id, e.companyName, j.jobPostingName, j.numberOfOpenPosition, j.creationDate, j.applicationDeadline, j.description) "
			+ "From Employer e Inner Join e.jobPostings j")
	List<JobPostingListDto> getJobPostingList();
	//Select e.company_name, j.job_posting_name, j.number_of_open_position, j.creation_date, j.application_deadline
	//from Employer e inner join JobPosting j 
	//on e.id = j.employer_id
}
