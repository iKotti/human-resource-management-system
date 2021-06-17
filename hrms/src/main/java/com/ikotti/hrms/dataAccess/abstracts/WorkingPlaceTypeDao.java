package com.ikotti.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikotti.hrms.entity.concretes.WorkingPlaceType;

public interface WorkingPlaceTypeDao extends JpaRepository<WorkingPlaceType, Integer> {

}
