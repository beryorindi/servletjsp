package com.mitrais.rms.dao;

import java.util.Optional;

import com.mitrais.rms.model.Employee;

public interface EmployeeDao extends Dao<Employee, Long> {
	 Optional<Employee> findByName(String name);
}
