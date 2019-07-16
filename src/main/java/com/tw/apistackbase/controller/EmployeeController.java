package com.tw.apistackbase.controller;

import com.tw.apistackbase.Service.EmployeeService;
import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.repository.EmpolyeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{empolyeeId}")
    public Employee getEmployeesById(@PathVariable String empolyeeId){
        return employeeService.getEmployeesById(empolyeeId);
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employees/{empolyeeId}")
    public Employee deleteEmployeeById(@PathVariable String empolyeeId){
        return employeeService.deleteEmployeeById(empolyeeId);
    }

    @GetMapping(value = "/employees", params = "ageMini")
    public List<Employee> findAgeAbove(@RequestParam int ageMini){
        return employeeService.findAgeAbove(ageMini);
    }
}
