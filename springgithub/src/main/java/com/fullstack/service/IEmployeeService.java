package com.fullstack.service;

import com.fullstack.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    Employee  signUp(Employee employee);

    Boolean signIn( String empEmailId,String empPassword);

    List<Employee> saveAll(List<Employee> employeeList);

    Optional<Employee> findById(long empId);

    List<Employee> findAll();

    Employee update(Employee employee,long empId);

    void deleteById(long empId);

    void deleteAll();
}
