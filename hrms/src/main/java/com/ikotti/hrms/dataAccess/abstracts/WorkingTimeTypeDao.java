package com.ikotti.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikotti.hrms.entity.concretes.WorkingTimeType;

public interface WorkingTimeTypeDao extends JpaRepository<WorkingTimeType, Integer> {

}