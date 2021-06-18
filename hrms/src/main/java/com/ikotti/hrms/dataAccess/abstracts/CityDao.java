package com.ikotti.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikotti.hrms.entity.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {
	
	City getByCityId(int id);

}
