package com.fullstack.service;


import com.fullstack.entity.Employee;
import com.fullstack.exception.RecordNotFoundException;
import com.fullstack.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService {
    private  final EmployeeRepository employeeRepository;

    @Override
    public Employee signUp(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Boolean signIn(String empEmailId, String empPassword) {
        boolean flag= false;
        Employee employee = employeeRepository.findByEmpEmailIdAndEmpPassword(empEmailId,empPassword);
        if(employee!=null){
            flag=true;
        }

        return flag;
    }

    @Override
    public List<Employee> saveAll(List<Employee> employeeList) {
        return employeeRepository.saveAll(employeeList);
    }

    @Override
    public Optional<Employee> findById(long empId) {
        return Optional.ofNullable(employeeRepository.findById(empId).orElseThrow(() -> new RecordNotFoundException("#Emp Id not found")));
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee update(Employee employee, long empId) {
        Employee employee1 = findById(empId).get();
        employee1.setEmpPassword(employee.getEmpPassword());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpEmailId(employee.getEmpEmailId());
        employee1.setEmpContactNumber(employee.getEmpContactNumber());
        return employeeRepository.save(employee1);
    }

    @Override
    public void deleteById(long empId) {
        employeeRepository.deleteById(empId);

    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();

    }
}
