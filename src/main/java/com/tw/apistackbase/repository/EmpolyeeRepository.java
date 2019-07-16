package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmpolyeeRepository {
    private static final Map<String , Employee> employees = new HashMap<>();

    static {
        employees.put("1", createEmployee("111", "hehe", 18, "male"));
        employees.put("2", createEmployee("112","hehe", 18, "male"));
        employees.put("3", createEmployee( "113","hehe", 18, "male"));
        employees.put("4", createEmployee( "114","hehe", 18, "male"));
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
        return employees.put(empolyeeId, createEmployee(empolyeeId, employee.getName(), employee.getAge(), employee.getGender()));
    }


    public Employee removeEmpolyee(String empolyeeId) {
        return employees.remove(empolyeeId);
    }

    public List<Employee> findAgeAbove(int ageMini) {
        return employees.values().stream().filter(item -> item.getAge() > ageMini).collect(Collectors.toList());
    }
}
