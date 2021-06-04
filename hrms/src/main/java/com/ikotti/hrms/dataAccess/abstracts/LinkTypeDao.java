package com.ikotti.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikotti.hrms.entity.concretes.LinkType;

public interface LinkTypeDao extends JpaRepository<LinkType, Integer>{

}
