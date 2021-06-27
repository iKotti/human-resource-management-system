package com.ikotti.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikotti.hrms.business.abstracts.EmployeeService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.core.utilities.results.SuccessDataResult;
import com.ikotti.hrms.core.utilities.results.SuccessResult;
import com.ikotti.hrms.dataAccess.abstracts.EmployeeDao;
import com.ikotti.hrms.entity.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService {
	
	private EmployeeDao employeeDao;

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(employeeDao.findAll());
	}

	@Override
	public Result add(Employee employee) {
		employeeDao.save(employee);
		return new SuccessResult("Sistem çalışanı başarıyla eklendi.");
	}

	@Override
	public Result update(Employee employee) {
		Employee updatedEmployee = employeeDao.getById(employee.getId());
		updatedEmployee = employee;
		employeeDao.save(updatedEmployee);
		return new SuccessResult("Sistem çalışanı başarıyla güncellendi.");
	}
}
