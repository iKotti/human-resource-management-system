package com.ikotti.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikotti.hrms.entity.concretes.CandidateSocialMedia;

public interface CandidateSocialMediaDao extends JpaRepository<CandidateSocialMedia, Integer>{
	List<CandidateSocialMedia> getAllByCandidateId(int candidateId);
}
