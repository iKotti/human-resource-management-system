package com.ikotti.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.entity.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {
	Candidate getByNationalIdentity(String nationalIdentity);
	Candidate getById(int id);
	
}
