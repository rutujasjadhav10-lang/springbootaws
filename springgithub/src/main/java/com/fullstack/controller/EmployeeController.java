package com.fullstack.controller;

import com.fullstack.entity.Employee;
import com.fullstack.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestControllerAdvice
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/employee")

public class EmployeeController {
    private final IEmployeeService employeeService;

    @PostMapping("/signup")
    public ResponseEntity<Employee> signUp(@RequestBody  Employee employee){
        return  new ResponseEntity<>(employeeService.signUp(employee), HttpStatus.CREATED);
    }

    @GetMapping("/signin")
    public ResponseEntity<Boolean> signIn(@PathVariable String empEmailId,@PathVariable String empPassword){
        return new ResponseEntity<>(employeeService.signIn(empEmailId,empPassword),HttpStatus.OK);
    }

    @PostMapping("/saveall")
    public ResponseEntity<List<Employee>> saveAll(@RequestBody List<Employee> employeeList){
        return new ResponseEntity<>(employeeService.saveAll(employeeList),HttpStatus.OK);

    }

    @GetMapping("/findbyid/{empId}")
    public ResponseEntity<Optional<Employee>> findById(@PathVariable long empId){
        return  new ResponseEntity<>(employeeService.findById(empId),HttpStatus.OK);

    }

    @GetMapping("findall")
    public ResponseEntity<List<Employee>> findAll(){
        return new ResponseEntity<>(employeeService.findAll(),HttpStatus.OK);
    }




}
