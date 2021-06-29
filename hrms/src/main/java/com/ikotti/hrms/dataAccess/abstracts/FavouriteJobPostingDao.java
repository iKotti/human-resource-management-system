package com.ikotti.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikotti.hrms.entity.concretes.FavouriteJobPosting;

public interface FavouriteJobPostingDao extends JpaRepository<FavouriteJobPosting, Integer>{
	List<FavouriteJobPosting> getAllByCandidateId(int candidateId);
	FavouriteJobPosting getByFavouriteId(int favouriteId);
}
