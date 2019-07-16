package com.tw.apistackbase.Service;

import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.repository.EmpolyeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    private EmpolyeeRepository repository;

    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }

    public Employee getEmployeesById(String empolyeeId){
        return repository.findById(empolyeeId);
    }

    public Employee createEmployee(Employee employee){
        return repository.addEmpolyee(employee);
    }

    public Employee updateEmployee(Employee employee){
        return repository.updateEmpolyee(employee);
    }

    public Employee deleteEmployeeById(String empolyeeId){
        return repository.removeEmpolyee(empolyeeId);
    }

    public List<Employee> findAgeAbove(int ageMini){
        return repository.findAgeAbove(ageMini);
    }
}
