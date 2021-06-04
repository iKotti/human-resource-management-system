package com.ikotti.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikotti.hrms.entity.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer>  {
	JobPosition getByTitle(String title);
}
