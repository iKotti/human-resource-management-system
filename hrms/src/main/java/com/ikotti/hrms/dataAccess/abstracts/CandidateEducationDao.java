package com.ikotti.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikotti.hrms.entity.concretes.CandidateEducation;

public interface CandidateEducationDao extends JpaRepository<CandidateEducation, Integer>{
	List<CandidateEducation> getAllByOrderByFinishYearAsc();
	List<CandidateEducation> getAllByCandidateId(int candidateId);
}
