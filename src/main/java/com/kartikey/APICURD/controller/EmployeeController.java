package com.kartikey.APICURD.controller;

import com.kartikey.APICURD.model.Employee;
import com.kartikey.APICURD.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public String createNewEmployee(@RequestBody Employee employee) {
        return employeeService.createNewEmployee(employee);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> empList = employeeService.getAllEmployees();
        return new ResponseEntity<>(empList, HttpStatus.OK);
    }

    @GetMapping("/employees/{empid}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long empid) {
        Optional<Employee> emp = employeeService.getEmployeeById(empid);
        return emp.map(employee -> new ResponseEntity<>(employee, HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/employees/{pechan}")
    public String updateEmployeeById(@PathVariable long pechan, @RequestBody Employee newEmp) {
        return employeeService.updateEmployeeById(pechan, newEmp);
    }

    @DeleteMapping("/employees/{empid}")
    public String deleteEmployeeById(@PathVariable long empid) {
        return employeeService.deleteEmployeeById(empid);
    }

    @DeleteMapping("/employees")
    public String deleteEmployees() {
        return employeeService.deleteAllEmployees();
    }
}
