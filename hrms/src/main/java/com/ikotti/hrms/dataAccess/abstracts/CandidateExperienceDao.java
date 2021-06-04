package com.ikotti.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikotti.hrms.entity.concretes.CandidateExperience;

public interface CandidateExperienceDao extends JpaRepository<CandidateExperience, Integer> {
	List<CandidateExperience> getAllByCandidateIdOrderByFinishDate(int candidateId);
}
