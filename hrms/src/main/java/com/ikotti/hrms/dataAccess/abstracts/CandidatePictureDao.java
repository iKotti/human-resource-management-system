package com.ikotti.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikotti.hrms.entity.concretes.CandidatePicture;

public interface CandidatePictureDao extends JpaRepository<CandidatePicture, Integer>{
	List<CandidatePicture> getAllByCandidateId(int CandidateId);
}
