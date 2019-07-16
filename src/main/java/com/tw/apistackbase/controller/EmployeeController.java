package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.repository.EmpolyeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    EmpolyeeRepository repository = new EmpolyeeRepository();

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return repository.findAll();

    }

    @GetMapping("/employees/{empolyeeId}")
    public Employee getEmployeesById(@PathVariable String empolyeeId){
        return repository.findById(empolyeeId);
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return repository.addEmpolyee(employee);
    }

    @DeleteMapping("/employees{empolyeeId}")
    public Employee deleteEmployeeById(@PathVariable String empolyeeId){
        return repository.removeEmpolyee(empolyeeId);
    }

    @GetMapping(value = "/employees", params = "ageMini")
    public List<Employee> findAgeAbove(@RequestParam int ageMini){
        return repository.findAgeAbove(ageMini);
    }
}
