package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Employee;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class EmployeeDBRepository implements EmpolyeeRepository{
    private static final Map<String , Employee> employees = new HashMap<>();

    static {
        employees.put("111", createEmployee("111", "hehe", 18, "male"));
        employees.put("112", createEmployee("112","hehe", 18, "male"));
        employees.put("113", createEmployee( "113","hehe", 18, "male"));
        employees.put("114", createEmployee( "114","hehe", 18, "male"));
    }

    private static Employee createEmployee(String empolyeeId, String name, int age, String gender) {
        Employee employee = new Employee();
        employee.setId(empolyeeId);
        employee.setAge(age);
        employee.setGender(gender);
        employee.setName(name);
        return employee;
    }

    public List<Employee> findAll() {
        return new ArrayList<>(employees.values());
    }

    public Employee findById(String empolyeeId) {
        return employees.get(empolyeeId);
    }

    public Employee addEmpolyee(Employee employee) {
        String empolyeeId = UUID.randomUUID().toString();
        employees.put(empolyeeId, createEmployee(empolyeeId, employee.getName(), employee.getAge(), employee.getGender()));
        return employee;
    }


    public Employee removeEmpolyee(String empolyeeId) {
        return employees.remove(empolyeeId);
    }

    public List<Employee> findAgeAbove(int ageMini) {
        return employees.values().stream().filter(item -> item.getAge() > ageMini).collect(Collectors.toList());
    }

    public Employee updateEmpolyee(Employee employee) {
        if (employees.containsKey(employee.getId())){
            //get
            Employee updateEmployee = employees.get(employee.getId());
            updateEmployee.setName(employee.getName());
            updateEmployee.setGender(employee.getGender());
            updateEmployee.setAge(employee.getAge());
            return employees.put(employee.getId(), updateEmployee);
        }
        return null;
    }
}

