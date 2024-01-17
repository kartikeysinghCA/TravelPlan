package com.kartikey.APICURD.repository;

import com.kartikey.APICURD.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
