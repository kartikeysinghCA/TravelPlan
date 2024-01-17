package com.kartikey.APICURD.service;

import com.kartikey.APICURD.model.Assoc;
import com.kartikey.APICURD.model.Employee;
import com.kartikey.APICURD.repository.EmployeeRepository;
import com.kartikey.APICURD.repository.AssocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AssocRepository assocRepository;

    public String createNewEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Employee " + employee.getEmpid() + " " + employee.getEmp_name() + " saved in DB!";
    }

    public List<Employee> getAllEmployees() {
        List<Employee> empList = new ArrayList<>();
        employeeRepository.findAll().forEach(empList::add);
        return empList;
    }

    public Optional<Employee> getEmployeeById(long empid) {
        return employeeRepository.findById(empid);
    }

    public String updateEmployeeById(long empid, Employee newEmp) {
        Optional<Employee> emp = employeeRepository.findById(empid);
        if (emp.isPresent()) {
            Employee oldEmp = emp.get();
            if(newEmp.getEmp_name()!=null)
                oldEmp.setEmp_name(newEmp.getEmp_name());
            if(newEmp.getEmp_age()>0)
                oldEmp.setEmp_age(newEmp.getEmp_age());
            if(newEmp.getEmp_city()!=null)
                oldEmp.setEmp_city(newEmp.getEmp_city());
            if(newEmp.getEmp_salary()!=null)
                oldEmp.setEmp_salary(newEmp.getEmp_salary());
            if(newEmp.getEmp_role()!=null)
                oldEmp.setEmp_role(newEmp.getEmp_role());
            employeeRepository.save(oldEmp);
            return "Employee " + empid + " " + oldEmp.getEmp_name() + " was Updated!";
        } else {
            return "Employee DNE!";
        }
    }

    public String deleteEmployeeById(long empid) {
        Optional<Employee> emp = employeeRepository.findById(empid);
        if (emp.isPresent()) {
            Employee existEmp = emp.get();

            deleteAssociationsByEmpId(empid);
            employeeRepository.deleteById(empid);
            return "Employee " + empid + " " + existEmp.getEmp_name() + " was Deleted!";
        } else {
            return "Employee DNE!";
        }
    }
    private void deleteAssociationsByEmpId(long empid) {
        List<Assoc> associationsToDelete = assocRepository.findByEmpid(empid);
        assocRepository.deleteAll(associationsToDelete);
    }

    public String deleteAllEmployees() {
        employeeRepository.deleteAll();
        assocRepository.deleteAll();
        return "All Employees Deleted!!";
    }
}
