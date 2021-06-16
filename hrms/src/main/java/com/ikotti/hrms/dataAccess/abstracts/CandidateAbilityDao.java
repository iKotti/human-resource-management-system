package com.ikotti.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.entity.concretes.CandidateAbility;

public interface CandidateAbilityDao extends JpaRepository<CandidateAbility, Integer> {
	List<CandidateAbility> getAllByCandidateId(int candidateId);
}
