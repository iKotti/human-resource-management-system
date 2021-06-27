package com.ikotti.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikotti.hrms.entity.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	Employee getById(int id);
}
