package com.ikotti.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikotti.hrms.entity.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {
	Candidate getByNationalIdentity(String nationalIdentity);
	Candidate getById(int id);
}
